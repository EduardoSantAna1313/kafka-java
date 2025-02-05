package br.com.edu.wikimedia.producer.app.application.config

import br.com.edu.wikimedia.producer.app.application.adapters.consumer.WikimediaStreamListener
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class WikimediaStreamConsumer(
    private val webClientBuilder: WebClient.Builder,
    private val wikimediaStreamListener: br.com.edu.wikimedia.producer.app.application.adapters.consumer.WikimediaStreamListener,
    @Value("\${app.wikimedia.url}") private val wikimediaUrl: String
) {

    @PostConstruct
    fun consumeStream() {
        val webClient = webClientBuilder.build()

        webClient.get()
            .uri(wikimediaUrl)
            .retrieve()
            .bodyToFlux(String::class.java)
            .subscribe { message ->
                wikimediaStreamListener.onMessage(message)
            }
    }
}
