package com.supernova.controller.request

import javax.validation.constraints.NotEmpty

data class PostAddressRequest(

    @field:NotEmpty(message = "ZipCode cannot be empty")
    var zipCode: String,

    @field:NotEmpty(message = "State cannot be empty")
    var state: String,

    @field:NotEmpty(message = "City cannot be empty")
    var city: String,

    @field:NotEmpty(message = "District cannot be empty")
    var district: String,

    @field:NotEmpty(message = "Street cannot be empty")
    var street: String,

    @field:NotEmpty(message = "Number cannot be empty")
    var number: String,

)
