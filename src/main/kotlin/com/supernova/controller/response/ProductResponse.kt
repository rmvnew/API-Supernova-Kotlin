package com.supernova.controller.response

import com.supernova.model.CategoryModel
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductResponse(

    var id: Int? = null,
    var name: String,
    var barcode: String,
    var quantity: Int,
    var price: BigDecimal,
    var isActive: Boolean,
    var createAt: LocalDateTime?,
    var updateAt: LocalDateTime?,
    var caregory: CategoryModel? = null
)