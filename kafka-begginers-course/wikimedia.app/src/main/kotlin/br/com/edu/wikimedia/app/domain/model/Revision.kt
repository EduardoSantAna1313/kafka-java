package br.com.edu.wikimedia.app.domain.model

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
data class Revision(
    @Column(name = "revision_old")
    val old: Long = 0,

    @Column(name = "revision_new")
    val new: Long = 0
)
