package com.supernova.controller

import com.supernova.controller.request.PostProductRequest
import com.supernova.controller.request.PutProductRequest
import com.supernova.controller.response.ProductResponse
import com.supernova.extension.toProductModel
import com.supernova.extension.toResponse
import com.supernova.model.ProductModel
import com.supernova.service.CategoryService
import com.supernova.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("product")
class ProductController(
    private val productService : ProductService,
    private val categoryService: CategoryService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody productRequest: PostProductRequest){
        productService.create(productRequest.toProductModel(categoryService))
    }


    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable:Pageable): Page<ProductResponse> {
        return productService.findAll(pageable).map { it.toResponse() }
    }

     @GetMapping("/active")
    fun findAllActive(@PageableDefault(page = 0, size = 10) pageable:Pageable): Page<ProductResponse> {
        return productService.findAllActive(pageable).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int): ProductModel? {
        return productService.findById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody @Valid productRequest: PutProductRequest){

        productService.update(id,productRequest)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        productService.delete(id)
    }



}