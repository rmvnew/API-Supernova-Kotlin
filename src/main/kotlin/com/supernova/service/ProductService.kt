package com.supernova.service

import com.supernova.model.ProductModel
import com.supernova.repository.ProductRepository
import org.springframework.stereotype.Service


@Service
class ProductService(
    val productRepository: ProductRepository
) {
    fun create(product: ProductModel) {


        productRepository.save(product)
    }

}
