package br.com.edu.wikimedia.app.application.services

import br.com.edu.wikimedia.app.domain.model.WikimediaMessage
import br.com.edu.wikimedia.app.domain.repository.WikimediaRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WikimediaService(
    val repository: WikimediaRepository
) {

    private val logger = LoggerFactory.getLogger(WikimediaService::class.java)

    @Transactional
    fun save(wikimediaMessage: WikimediaMessage): WikimediaMessage {
        logger.debug("Salvando a mensagem $wikimediaMessage")
        return repository.save(wikimediaMessage)
    }

}