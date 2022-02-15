package com.supernova.controller.response

import java.time.LocalDateTime

data class PhoneResponse(
    var id: Int? = null,
    var phone: String,
    var isActive: Boolean,
    var createAt: LocalDateTime?,
    var updateAt: LocalDateTime?
)