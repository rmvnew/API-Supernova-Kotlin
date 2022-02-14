package com.supernova.controller

import com.supernova.controller.request.PostProductRequest
import com.supernova.extension.toProductModel
import com.supernova.service.CategoryService
import com.supernova.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("product")
class ProductController(
    val productService : ProductService,
    val categoryService: CategoryService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody productRequest: PostProductRequest){
        productService.create(productRequest.toProductModel(categoryService))
    }

}