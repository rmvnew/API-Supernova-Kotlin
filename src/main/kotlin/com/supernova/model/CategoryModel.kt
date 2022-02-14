package com.supernova.model

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "category")
data class CategoryModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int? = null,

    @Column
    var name:String,

    @Column(name = "is_active")
    var isActive: Boolean,

    @Column(name = "create_at")
    var createAt: LocalDateTime?,

    @Column(name = "update_at")
    var updateAt: LocalDateTime?

//    @OneToMany(mappedBy = "category")
//    var products : MutableSet<ProductModel>

)