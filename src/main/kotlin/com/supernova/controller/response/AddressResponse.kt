package com.supernova.controller.response

import java.time.LocalDateTime

data class AddressResponse(
    var id: Int? = null,
    var zipCode: String,
    var state: String,
    var city: String,
    var district: String,
    var street: String,
    var number: String,
    var isActive: Boolean,
    var createAt: LocalDateTime? = null,
    var updateAt: LocalDateTime? = null
)
