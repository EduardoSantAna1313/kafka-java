package br.com.edu.wikimedia.consumer.infraestructure.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer

@Configuration
class KafkaConsumerConfig(
    @Value("\${app.consumer.bootstrap-servers}")
    val bootstrapServer: String,

    @Value("\${app.consumer.group-id}")
    val groupId: String
) {


    @Bean
    fun kafkaListenerContainerFactory(): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> {
        val factory =
            ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = consumerFactory()
        factory.setConcurrency(1)
        factory.containerProperties.pollTimeout = 3000
        return factory
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        return DefaultKafkaConsumerFactory<String, String>(kafkaProperties())
    }

    fun kafkaProperties(): Map<String, Any?> = mapOf(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServer,
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.qualifiedName,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.qualifiedName,
        ConsumerConfig.GROUP_ID_CONFIG to groupId,
        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "latest",
    )

}
