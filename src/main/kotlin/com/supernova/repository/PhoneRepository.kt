package com.supernova.repository

import com.supernova.model.PhoneModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneRepository : JpaRepository<PhoneModel, Int> {
    abstract fun findByIsActiveTrue(pageable: Pageable): Page<PhoneModel>

}
