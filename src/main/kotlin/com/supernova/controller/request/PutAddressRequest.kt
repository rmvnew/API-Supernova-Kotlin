package com.supernova.controller.request

import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty

data class PutAddressRequest(
    @field:NotEmpty(message = "ZipCode cannot be empty")
    var zipCode: String,

    var state: String,

    var city: String,

    var district: String,

    var street: String,

    var number: String,

    var isActive: Boolean,

    var createAt: LocalDateTime?,

    var updateAt: LocalDateTime?
)