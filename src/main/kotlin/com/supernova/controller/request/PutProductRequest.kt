package com.supernova.controller.request

import com.supernova.util.regex_special_character
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class PutProductRequest(
    @field:NotEmpty(message = "the category name cannot be empty")
    @field:Pattern(regexp = regex_special_character)
    var name:String,

    var barcode: String,

    var quantity: Int,

    var price: BigDecimal,

    var categoryId: Int
)
