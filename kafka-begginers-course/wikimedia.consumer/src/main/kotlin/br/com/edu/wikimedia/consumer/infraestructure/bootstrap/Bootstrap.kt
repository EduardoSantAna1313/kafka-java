package br.com.edu.wikimedia.consumer.infraestructure.bootstrap

import org.opensearch.client.RequestOptions
import org.opensearch.client.RestHighLevelClient
import org.opensearch.client.indices.CreateIndexRequest
import org.opensearch.client.indices.GetIndexRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

val logger: Logger = LoggerFactory.getLogger(Bootstrap::class.java)

@Component
class Bootstrap(
    private val client: RestHighLevelClient
): CommandLineRunner {

    override fun run(vararg args: String?) {
        val request = CreateIndexRequest("wikimedia")

        val exists = client.indices().exists(GetIndexRequest("wikimedia"), RequestOptions.DEFAULT)

        logger.info("The index 'wikimedia' already exists ? $exists")

        if (!exists) {
            client.indices().create(request, RequestOptions.DEFAULT)
            logger.info("Index 'wikiemedia' has been created!!!")
        }
    }

}
