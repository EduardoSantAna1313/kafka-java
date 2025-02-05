package br.com.edu.wikimedia.producer.app.domain.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.time.Instant
import java.util.UUID

@JsonInclude(JsonInclude.Include.NON_NULL)
data class WikimediaMessage(

    val wikimediaChangeId: UUID = UUID.randomUUID(),

    val id: Long? = null,

    @field:JsonProperty("\$schema")
    val schema: String,

    val meta: Meta = Meta(),

    val type: String = "",

    val namespace: Int = 0,

    val title: String = "",

    @field:JsonProperty("title_url")
    val titleUrl: String = "",

    val comment: String = "",

    val timestamp: Long = System.currentTimeMillis(),

    val user: String = "",

    val bot: Boolean = true,

    @field:JsonProperty("notify_url")
    val notifyUrl: String = "",

    val minor: Boolean = false,

    val patrolled: Boolean = false,

    val length: br.com.edu.wikimedia.producer.app.domain.model.Length = br.com.edu.wikimedia.producer.app.domain.model.Length(),

    val revision: Revision = Revision(),

    @field:JsonProperty("server_url")
    val serverUrl: String = "",

    @field:JsonProperty("server_name")
    val serverName: String = "",

    @field:JsonProperty("server_script_path")
    val serverScriptPath: String = "",

    val wiki: String = "",

    @field:JsonProperty("parsedcomment")
    val parsedComment: String = ""
) {
    fun getTimestampAsInstant(): Instant {
        return Instant.ofEpochSecond(timestamp)
    }

    fun toJsonString(): String {
        val mapper = jacksonObjectMapper()
        mapper.registerModules(JavaTimeModule())
        return mapper.writeValueAsString(this)
    }
}
