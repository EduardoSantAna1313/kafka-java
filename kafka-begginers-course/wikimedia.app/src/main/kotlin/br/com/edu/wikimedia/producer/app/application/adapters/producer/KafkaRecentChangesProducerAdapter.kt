package br.com.edu.wikimedia.producer.app.application.adapters.producer

import br.com.edu.wikimedia.producer.app.domain.ports.QueueProducerPort
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service("recent-changes-producer")
class KafkaRecentChangesProducerAdapter(

    @Value("\${app.producer.topic-name}")
    val topicName: String,

    val producer: KafkaProducer<String, String>

) : QueueProducerPort {

    override fun sendMessage(message: String) {
        producer.send(ProducerRecord(topicName, message))
    }

}
