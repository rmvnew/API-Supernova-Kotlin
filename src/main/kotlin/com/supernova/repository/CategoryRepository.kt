package com.supernova.repository

import com.supernova.model.CategoryModel
import com.supernova.util.native_query_select_categories_active
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<CategoryModel, Int>{

    abstract fun findByName(name: String): Boolean

    abstract fun existsByName(name: String): Boolean

    @Query(nativeQuery = true,value = native_query_select_categories_active)
    abstract fun findAllActive(pageable: Pageable): Page<CategoryModel>

}
