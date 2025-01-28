package br.com.edu.wikimedia.app.application.adapters.consumer

import br.com.edu.wikimedia.app.application.services.WikimediaService
import br.com.edu.wikimedia.app.domain.model.WikimediaMessage
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class WikimediaStreamListener(
    val service: WikimediaService,
    val mapper: ObjectMapper
) {

    private val logger = LoggerFactory.getLogger(WikimediaStreamListener::class.java)

    fun onMessage(message: String) {
        try {
            logger.debug("Received message: $message")
            val change = mapper.readValue(message, WikimediaMessage::class.java)
            service.save(change)
        } catch (error: Exception) {
            logger.error("Ocorreu um erro ao processar a mensagem $message", error)
        }
    }

}