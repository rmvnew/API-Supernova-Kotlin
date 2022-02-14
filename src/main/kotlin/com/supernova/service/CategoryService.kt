package com.supernova.service

import com.supernova.controller.request.PutCategoryRequest
import com.supernova.enums.Errors
import com.supernova.exception.BadRequestException
import com.supernova.exception.NotFoundException
import com.supernova.extension.toCategoryModel
import com.supernova.extension.validLength
import com.supernova.model.CategoryModel
import com.supernova.repository.CategoryRepository
import com.supernova.util.max_length_name
import com.supernova.util.min_length_name
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*


@Service
class CategoryService(
    val categoryRepository: CategoryRepository
) {

    fun create(category: CategoryModel) {

        if (categoryRepository.existsByName(category.name)) {
            throw BadRequestException(Errors.SYS001.message, Errors.SYS001.code)
        }

        category.name = category.name.trim()
        if(category.name.isNullOrEmpty()){
            throw BadRequestException(Errors.CA002.message,Errors.CA002.code)
        }

        category.name.validLength()

        category.name = category.name.uppercase(Locale.getDefault())

        categoryRepository.save(category)
    }

    fun findAll(pageable: Pageable): Page<CategoryModel> {
        return categoryRepository.findAll(pageable)
    }

    fun findAllActive(pageable: Pageable): Page<CategoryModel> {

        return categoryRepository.findAllActive(pageable)

    }

    fun findById(id: Int): CategoryModel {
        return categoryRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.CA001.message.format(id), Errors.CA001.code) }
    }

    fun update(id: Int, categoryRequest: PutCategoryRequest) {

        val categorySaved = this.findById(id)
        val category = categoryRequest.toCategoryModel(categorySaved)
        category.name = category.name.uppercase(Locale.getDefault())

        categoryRepository.save(category)

    }

    fun delete(id: Int) {

        val categorySaved = this.findById(id)
        categorySaved.isActive = false
        categoryRepository.save(categorySaved)

    }


}
