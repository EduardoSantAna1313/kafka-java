package br.com.edu.wikimedia.app.domain.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.time.Instant
import java.util.UUID

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Wikimedia_Change")
@Table(name = "Wikimedia_Change")
data class WikimediaMessage(

    @Id
    @Column(name = "wikimedia_change_id", columnDefinition = "uuid")
    val wikimediaChangeId: UUID = UUID.randomUUID(),

    @Column(name = "id")
    val id: Long? = null,

    @field:JsonProperty("\$schema")
    @Column(name = "schema")
    val schema: String,

    @Embedded
    val meta: Meta = Meta(),

    @Column(name = "type")
    val type: String = "",

    @Column(name = "namespace")
    val namespace: Int = 0,

    @Column(name = "title")
    val title: String = "",

    @field:JsonProperty("title_url")
    @Column(name = "title_url", columnDefinition = "text")
    val titleUrl: String = "",

    @Column(name = "comment", columnDefinition = "text")
    val comment: String = "",

    @Column(name = "timestamp")
    val timestamp: Long = System.currentTimeMillis(),

    @Column(name = "\"user\"")
    val user: String = "",

    @Column(name = "bot")
    val bot: Boolean = true,

    @field:JsonProperty("notify_url")
    @Column(name = "notify_url")
    val notifyUrl: String = "",

    @Column(name = "minor")
    val minor: Boolean = false,

    @Column(name = "patrolled")
    val patrolled: Boolean = false,

    @Embedded
    val length: Length = Length(),

    @Embedded
    val revision: Revision  = Revision(),

    @field:JsonProperty("server_url")
    @Column(name = "server_url")
    val serverUrl: String = "",

    @field:JsonProperty("server_name")
    @Column(name = "server_name")
    val serverName: String = "",

    @field:JsonProperty("server_script_path")
    @Column(name = "server_script_path")
    val serverScriptPath: String = "",

    @Column(name = "wiki")
    val wiki: String = "",

    @field:JsonProperty("parsedcomment")
    @Column(name = "parsed_comment", columnDefinition = "text")
    val parsedComment: String = ""
) {
    fun getTimestampAsInstant(): Instant {
        return Instant.ofEpochSecond(timestamp)
    }
}
