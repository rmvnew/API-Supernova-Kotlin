package com.supernova.repository

import com.supernova.model.CategoryModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<CategoryModel, Int>{


    abstract fun existsByName(name: String): Boolean
    abstract fun findByIsActiveTrue(pageable: Pageable): Page<CategoryModel>

}
