package com.supernova.model

import java.time.LocalDateTime
import javax.persistence.*


@Entity(name = "phone")
data class PhoneModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var phone : String,

    @Column(name = "is_active")
    var isActive: Boolean,

    @Column(name = "create_at")
    var createAt: LocalDateTime? = null,

    @Column(name = "update_at")
    var updateAt: LocalDateTime? = null
)