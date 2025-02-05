package br.com.edu.wikimedia.producer.app.domain.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Revision(
    val old: Long = 0,

    val new: Long = 0
)
