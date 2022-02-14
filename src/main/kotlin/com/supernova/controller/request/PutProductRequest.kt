package com.supernova.controller.request

import com.supernova.model.CategoryModel
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty

data class PutProductRequest(
    @field:NotEmpty(message = "the category name cannot be empty")
    var name:String,

    var barcode: String,

    var quantity: Int,

    var price: BigDecimal,

    var categoryId: Int
)
