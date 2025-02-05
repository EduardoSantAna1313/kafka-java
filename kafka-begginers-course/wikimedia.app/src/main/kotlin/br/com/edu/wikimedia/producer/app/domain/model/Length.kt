package br.com.edu.wikimedia.producer.app.domain.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Length(
    val old: Int = 0,
    val new: Int = 0
)
