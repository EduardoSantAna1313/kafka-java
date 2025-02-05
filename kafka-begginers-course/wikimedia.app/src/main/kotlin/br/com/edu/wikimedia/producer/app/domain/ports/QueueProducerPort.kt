package br.com.edu.wikimedia.producer.app.domain.ports

interface QueueProducerPort {

    fun sendMessage(message: String)

}
