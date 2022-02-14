package com.supernova.controller.request

import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty

data class PutCategoryRequest(

    @field:NotEmpty(message = "the category name cannot be empty")
    var name: String,

    var isActive: Boolean,

    var createAt: LocalDateTime?,

    var updateAt: LocalDateTime?
)
