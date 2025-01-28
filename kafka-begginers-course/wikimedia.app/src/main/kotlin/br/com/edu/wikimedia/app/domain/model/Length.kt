package br.com.edu.wikimedia.app.domain.model

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
data class Length(
    @Column(name = "length_old")
    val old: Int = 0,

    @Column(name = "length_new")
    val new: Int = 0
)