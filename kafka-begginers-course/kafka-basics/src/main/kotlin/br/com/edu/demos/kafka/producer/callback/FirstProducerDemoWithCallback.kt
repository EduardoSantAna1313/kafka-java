package br.com.edu.demos.kafka.producer.callback

import br.com.edu.demos.kafka.producer.FirstProducerDemo
import org.apache.kafka.clients.producer.Callback
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Exception
import java.util.Properties

class FirstProducerDemoWithCallback

val logger: Logger = LoggerFactory.getLogger(FirstProducerDemo::class.java)

/**
 * kafka-topics.sh --bootstrap-server localhost:9092 --topic demo_java_topic --create
 */
fun main() {
    logger.info("hello world")

    val properties = Properties()

    // connect to local server
    properties["bootstrap.servers"] = "localhost:19092"

    properties["key.serializer"] = StringSerializer::class.qualifiedName
    properties["value.serializer"] = StringSerializer::class.qualifiedName
    properties["batch.size"] = "400"

    // create the producer
    val producer = KafkaProducer<String, String>(properties)

    for ( i in 1..10) {
        for (j in 1 .. 30) {
            val record = ProducerRecord<String, String>("demo_java_topic", "hello world")

            producer.send(record, ProducerCallback())
        }

        Thread.sleep(500)
    }

    producer.flush()

    producer.close()
}

class ProducerCallback : Callback {
    override fun onCompletion(metadata: RecordMetadata, error: Exception?) {

        error?.let {
            logger.error("An error occurred when producing data.", error)
            return
        }

        logger.info(
            """
                Received new metadata
                Topic: ${metadata.topic()}
                Partition: ${metadata.partition()}
                Offset: ${metadata.offset()}
                Timestamp: ${metadata.timestamp()}
                
            """.trimIndent()
        )
    }

}