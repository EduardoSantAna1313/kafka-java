package br.com.edu.wikimedia.producer.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WikimediaProducerApplication

fun main(args: Array<String>) {
	runApplication<WikimediaProducerApplication>(*args)
}
