package br.com.edu.wikimedia.app.application.services

import br.com.edu.wikimedia.app.domain.model.WikimediaMessage
import br.com.edu.wikimedia.app.domain.ports.QueueProducerPort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class WikimediaService(
    val producerPort: QueueProducerPort
) {

    private val logger = LoggerFactory.getLogger(WikimediaService::class.java)


    fun process(wikimediaMessage: WikimediaMessage) {
        logger.debug("Enviando menssagem para fila. Message: '{}'.", wikimediaMessage)
        producerPort.sendMessage(wikimediaMessage.toJsonString())
    }

}
