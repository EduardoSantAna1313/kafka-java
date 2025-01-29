package br.com.edu.wikimedia.app.application.config

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

        return KafkaProducer<String, String>(props)
    }

}
