package com.supernova.controller.request

import javax.validation.constraints.NotEmpty

data class PostPhoneRequest(

    @field:NotEmpty(message = "the category name cannot be empty")
    var phone: String,


)
