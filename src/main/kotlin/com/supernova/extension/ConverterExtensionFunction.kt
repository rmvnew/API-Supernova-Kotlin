package com.supernova.extension

import com.supernova.controller.request.PostCategoryRequest
import com.supernova.controller.request.PostProductRequest
import com.supernova.controller.request.PutCategoryRequest
import com.supernova.controller.request.PutProductRequest
import com.supernova.controller.response.CategoryResponse
import com.supernova.controller.response.ProductResponse
import com.supernova.enums.Errors
import com.supernova.exception.BadRequestException
import com.supernova.model.CategoryModel
import com.supernova.model.ProductModel
import com.supernova.service.CategoryService
import com.supernova.service.ProductService
import com.supernova.util.max_length_name
import com.supernova.util.min_length_name
import java.time.LocalDateTime

/**
 * Categories
 */

fun PostCategoryRequest.toCategoryModel(): CategoryModel {
    return CategoryModel(
        name = this.name,
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null

    )
}

fun CategoryModel.toResponse(): CategoryResponse {
    return CategoryResponse(
        id = this.id,
        name = this.name,
        isActive = this.isActive,
        createAt = this.createAt,
        updateAt = this.updateAt
    )
}

fun PutCategoryRequest.toCategoryModel(category: CategoryModel): CategoryModel {
    return CategoryModel(
        id = category.id,
        name = this.name,
        isActive = category.isActive,
        createAt = category.createAt,
        updateAt = LocalDateTime.now()

    )
}

/**
 * String
 */

fun String.validLength() {

    val nameLength = this.trim().length

    when {
        nameLength < min_length_name -> throw BadRequestException(Errors.SYS002.message, Errors.SYS002.code)
        nameLength > max_length_name -> throw BadRequestException(Errors.SYS003.message, Errors.SYS003.code)
    }

}


/**
 * product
 */


fun PostProductRequest.toProductModel(
    categoryService: CategoryService
): ProductModel {

    return ProductModel(

        name = this.name,
        barcode = this.barcode,
        quantity = this.quantity,
        price = this.price,
        category = categoryService.findById(this.categoryId),
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null

    )
}

fun ProductModel.toResponse(): ProductResponse {
    return ProductResponse(
        id = this.id,
        name = this.name,
        barcode = this.barcode,
        quantity = this.quantity,
        price = this.price,
        isActive = this.isActive,
        createAt = this.createAt,
        updateAt = this.updateAt,
        caregory = this.category
    )
}

fun PutProductRequest.toProductModel(productModel:ProductModel, categoryService: CategoryService):ProductModel{
    return ProductModel(
        id = productModel.id,
        name = this.name,
        barcode = this.barcode,
        quantity = this.quantity,
        price = this.price,
        category = categoryService.findById(this.categoryId),
        isActive = productModel.isActive,
        createAt = productModel.createAt,
        updateAt = LocalDateTime.now()
    )
}


