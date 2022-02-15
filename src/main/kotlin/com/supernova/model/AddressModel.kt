package com.supernova.model

import com.supernova.enums.Errors
import com.supernova.exception.NotFoundException
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "address")
data class AddressModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "zip_code")
    var zipCode: String,

    @Column
    var state: String,

    @Column
    var city: String,

    @Column
    var district: String,

    @Column
    var street: String,

    @Column
    var number: String,

    @Column(name = "is_active")
    var isActive: Boolean,

    @Column(name = "create_at")
    var createAt: LocalDateTime? = null,

    @Column(name = "update_at")
    var updateAt: LocalDateTime? = null
) {

    fun validateActive(active: Boolean) {

        println(active)
        when{
            !active -> throw NotFoundException(Errors.SYS004.message, Errors.SYS004.code)
        }

    }

}