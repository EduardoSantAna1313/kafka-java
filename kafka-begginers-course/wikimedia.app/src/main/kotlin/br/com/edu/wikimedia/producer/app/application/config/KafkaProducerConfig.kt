package br.com.edu.wikimedia.producer.app.application.config

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class KafkaProducerConfig(
    @Value("\${app.producer.bootstrap-servers}")
    val bootstrapServer: String
) {

    @Bean
    fun kafkaProducer(): KafkaProducer<String, String> {
        val props = Properties()
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer)
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.qualifiedName)
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.qualifiedName)
        props.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true")

        // High throughput config
        props.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy")
        props.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "${32 * 1024}")
        props.setProperty(ProducerConfig.LINGER_MS_CONFIG, "20")
        return KafkaProducer<String, String>(props)
    }

}
