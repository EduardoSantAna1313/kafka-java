package br.com.edu.wikimedia.consumer.infraestructure.config

import org.apache.http.HttpHost
import org.opensearch.client.RestClient
import org.opensearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URI

@Configuration
class OpenSearchConfig {

    @Bean
    fun openSearchClient(@Value("\${opensearch.url}") url: String): RestHighLevelClient {
        val connUri = URI.create(url)

        return RestHighLevelClient(RestClient
            .builder(HttpHost(connUri.host, connUri.port, connUri.scheme)))
    }

}
