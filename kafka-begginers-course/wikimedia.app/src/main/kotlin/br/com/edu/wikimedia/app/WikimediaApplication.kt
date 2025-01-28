package br.com.edu.wikimedia.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WikimediaApplication

fun main(args: Array<String>) {
	runApplication<WikimediaApplication>(*args)
}
