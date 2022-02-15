package com.supernova.controller.request

import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty

data class PutPhoneRequest(

    @field:NotEmpty(message = "the category name cannot be empty")
    var phone: String,

    var isActive: Boolean,

    var createAt: LocalDateTime?,

    var updateAt: LocalDateTime?
)
