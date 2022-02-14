package com.supernova.repository

import com.supernova.model.ProductModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository : JpaRepository<ProductModel, Int> {

}
