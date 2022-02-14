package com.supernova.controller.request

import javax.validation.constraints.NotEmpty

data class PostCategoryRequest(

    @field:NotEmpty(message = "the category name cannot be empty")
    var name: String,


)
