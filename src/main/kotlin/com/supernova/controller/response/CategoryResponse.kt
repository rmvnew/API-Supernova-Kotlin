package com.supernova.controller.response

import java.time.LocalDateTime

data class CategoryResponse(
    var id: Int? = null,
    var name: String,
    var isActive: Boolean,
    var createAt: LocalDateTime?,
    var updateAt: LocalDateTime?
)