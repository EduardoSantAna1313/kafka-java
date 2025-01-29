package br.com.edu.wikimedia.app.domain.ports

interface QueueProducerPort {

    fun sendMessage(message: String)

}
