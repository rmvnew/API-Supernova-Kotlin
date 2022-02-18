package com.supernova.controller

import com.supernova.controller.request.PostCategoryRequest
import com.supernova.controller.request.PutCategoryRequest
import com.supernova.controller.response.CategoryResponse
import com.supernova.extension.toCategoryModel
import com.supernova.extension.toResponse
import com.supernova.service.CategoryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("category")
class CategoryController(
    private val categoryService: CategoryService
) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody category: PostCategoryRequest){
        categoryService.create(category.toCategoryModel())
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable):Page<CategoryResponse>{
        return categoryService.findAll(pageable).map { it.toResponse() }
    }

     @GetMapping("/active")
    fun findAllActive(@PageableDefault(page = 0, size = 10) pageable: Pageable):Page<CategoryResponse>{
        return categoryService.findAllActive(pageable).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int):CategoryResponse{
        return categoryService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody @Valid category: PutCategoryRequest){

        categoryService.update(id,category)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        categoryService.delete(id)
    }


}