package br.com.edu.wikimedia.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class WikimediaConsumerApp

fun main(args: Array<String>) {
    runApplication<WikimediaConsumerApp>(*args)
}