package com.supernova.repository

import com.supernova.model.AddressModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository: JpaRepository<AddressModel, Int> {
    abstract fun findByIsActiveTrue(pageable: Pageable): Page<AddressModel>

}
