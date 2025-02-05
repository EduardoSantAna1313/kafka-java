package br.com.edu.wikimedia.consumer.demos.kafka.producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.Properties

class FirstProducerDemo

val logger: Logger = LoggerFactory.getLogger(FirstProducerDemo::class.java)

/**
 * kafka-topics.sh --bootstrap-server localhost:9092 --topic demo_java_topic --create
 */
fun main() {
    br.com.edu.demos.kafka.producer.callback.logger.info("hello world")

    val properties = Properties()

    // connect to local server
    properties["bootstrap.servers"] = "localhost:19092"

    properties["key.serializer"] = StringSerializer::class.qualifiedName
    properties["value.serializer"] = StringSerializer::class.qualifiedName

    // create the producer
    val producer = KafkaProducer<String, String>(properties)

    val record = ProducerRecord<String, String>("demo_java_topic", "hello world")

    for (i in 1..10) {
        producer.send(record)
    }

    producer.flush()

    producer.close()
}