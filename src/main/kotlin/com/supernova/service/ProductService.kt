package com.supernova.service

import com.supernova.controller.request.PutProductRequest
import com.supernova.enums.Errors
import com.supernova.exception.BadRequestException
import com.supernova.exception.NotFoundException
import com.supernova.extension.toProductModel
import com.supernova.extension.validLength
import com.supernova.model.ProductModel
import com.supernova.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*


@Service
class ProductService(
    val productRepository: ProductRepository,
    val categoryService: CategoryService
) {
    fun create(product: ProductModel) {

        if (productRepository.existsByName(product.name)) {
            throw BadRequestException(Errors.SYS001.message, Errors.SYS001.code)
        }

        product.name = product.name.trim()
        if (product.name.isNullOrEmpty()) {
            throw BadRequestException(Errors.CA002.message, Errors.CA002.code)
        }

        product.name = product.name.uppercase(Locale.getDefault())

        product.name.validLength()

        productRepository.save(product)
    }

    fun findAll(pageable: Pageable): Page<ProductModel> {
        return productRepository.findAll(pageable)
    }


    fun findAllActive(pageable: Pageable): Page<ProductModel> {
        return productRepository.findByIsActiveTrue(pageable)
    }

    fun findById(id: Int): ProductModel {
        return productRepository.findById(id).orElseThrow { NotFoundException(Errors.PO001.message, Errors.PO001.code) }
    }

    fun update(id: Int, productRequest: PutProductRequest) {

        val productSaved = this.findById(id)
        val product = productRequest.toProductModel(productSaved,categoryService)
        product.name = product.name.uppercase(Locale.getDefault())
        productRepository.save(product)

    }

    fun delete(id: Int) {
        val productSaved = this.findById(id)
        productSaved.isActive = false
        productRepository.save(productSaved)
    }

}
