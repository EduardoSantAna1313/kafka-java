package br.com.edu.wikimedia.app.domain.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.Instant

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
data class Meta(
    @Column(name = "meta_uri", columnDefinition = "text")
    val uri: String = "",

    @field:JsonProperty("request_id")
    @Column(name = "meta_request_id")
    val requestId: String = "",

    @Column(name = "meta_id")
    val id: String = "",

    @Column(name = "meta_dt")
    val dt: Instant = Instant.now(),

    @Column(name = "meta_domain")
    val domain: String = "",

    @Column(name = "meta_stream")
    val stream: String = "",

    @Column(name = "meta_topic")
    val topic: String = "",

    @Column(name = "meta_partition")
    val partition: Int = 0,

    @Column(name = "meta_offset")
    val offset: Long = 0L
)
