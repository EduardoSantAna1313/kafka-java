package br.com.edu.wikimedia.consumer.infraestructure.adapter.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.opensearch.action.index.IndexRequest
import org.opensearch.client.RequestOptions
import org.opensearch.client.RestHighLevelClient
import org.opensearch.common.xcontent.XContentType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

private val logger: Logger = LoggerFactory.getLogger(KafkaConsumer::class.java)

@Component
class KafkaConsumerAdapter(
    private val client: RestHighLevelClient,

    private val mapper: ObjectMapper
) {

    @KafkaListener(topics = ["wikimedia-recent-changes"], groupId = "wikimedia-consumer-1")
    fun listen(data: String) {
        logger.debug("data: $data")

        val json = mapper.readTree(data)

        val id = json["meta"]["id"].textValue()

        val indexRequest = IndexRequest("wikimedia").source(data, XContentType.JSON)
        indexRequest.id(id)

        val response = client.index(indexRequest, RequestOptions.DEFAULT)

        logger.info("GET /${response.index}/_doc/${response.id}")
    }

}