package br.com.edu.wikimedia.app.domain.repository

import br.com.edu.wikimedia.app.domain.model.WikimediaMessage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WikimediaRepository : JpaRepository<WikimediaMessage, Long> {
}