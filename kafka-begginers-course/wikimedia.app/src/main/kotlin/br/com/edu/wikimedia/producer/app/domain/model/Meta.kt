package br.com.edu.wikimedia.producer.app.domain.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Meta(
    val uri: String = "",

    @field:JsonProperty("request_id")
    val requestId: String = "",

    val id: String = "",

    val dt: Instant = Instant.now(),

    val domain: String = "",

    val stream: String = "",

    val topic: String = "",

    val partition: Int = 0,

    val offset: Long = 0L
)
