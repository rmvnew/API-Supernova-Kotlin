package com.supernova.controller.response

import com.supernova.enums.UserProfile
import com.supernova.model.CategoryModel
import java.math.BigDecimal
import java.time.LocalDateTime

data class UserResponse(

    var id: Int? = null,
    var name: String,
    var register: String,
    var email:String,
    var password:String? = null,
    var profile: String?,
    var address : AddressResponse,
    var phone: PhoneResponse,
    var isActive: Boolean,
    var createAt: LocalDateTime?,
    var updateAt: LocalDateTime?

)