package br.com.edu.demos.kafka.consumer

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.errors.WakeupException
import org.apache.kafka.common.serialization.StringDeserializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.Duration
import java.util.Properties

class FirstConsumerWithShutdown

fun main() {

    logger.info("""
        Iniciando o Kafka Consumer 
    """.trimIndent())

    val groupId = "kotlin-app"

    val topic = "demo_java_topic"

    val props = Properties()
    props["bootstrap.servers"] = "localhost:19092"

    props["key.deserializer"] = StringDeserializer::class.qualifiedName
    props["value.deserializer"] = StringDeserializer::class.qualifiedName

    props["group.id"] = groupId
    props["auto.offset.reset"] = "earliest"


    val consumer = KafkaConsumer<String, String>(props)

    val mainThread = Thread.currentThread()

    Runtime.getRuntime().addShutdownHook(Thread {
        logger.info("Detected a shutdown. Exit calling the consumer.wakeup()....")

        consumer.wakeup()

        // join the main thread to allow the execution of the code in the main thread
        mainThread.join()
    })


    consumer.subscribe(listOf(topic))


    runCatching {
        while (true) {

            logger.info("Polling....")

            consumer.poll(Duration.ofMillis(1000)).forEach {
                logger.info("""
            key: ${it.key()}    value: ${it.value()}
            Partition: ${it.partition()}    offset: ${it.offset()}
            """.trimIndent())
            }
        }
    }.onFailure {

        if (it is WakeupException)
            logger.info("Consumer is starting to shut down ....")
        else
            logger.error("Unexpected exception in the consumer ...")
    }.run {
        consumer.close()
        logger.info("The consumer is now gracefully shutdown !")
    }

}