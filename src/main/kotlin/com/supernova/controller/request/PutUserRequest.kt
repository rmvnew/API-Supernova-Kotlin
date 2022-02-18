package com.supernova.controller.request

import com.supernova.enums.UserProfile
import com.supernova.util.regex_special_character
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class PutUserRequest(
    @field:NotEmpty(message = "the category name cannot be empty")
    @field:Pattern(regexp = regex_special_character)
    var name:String,

    var register: String,

    var email:String,

    var password:String,

    var profile: String,

    var phone: PostPhoneRequest,

    var address : PostAddressRequest

)
