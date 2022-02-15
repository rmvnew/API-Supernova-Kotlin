package com.supernova.controller.request

import com.supernova.util.regex_special_character
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class PutCategoryRequest(

    @field:NotEmpty(message = "the category name cannot be empty")
    @field:Pattern(regexp = regex_special_character)
    var name: String,

    var isActive: Boolean,

    var createAt: LocalDateTime?,

    var updateAt: LocalDateTime?
)
