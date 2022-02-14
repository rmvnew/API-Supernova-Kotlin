package com.supernova.model

import com.fasterxml.jackson.annotation.JsonAlias
import org.springframework.web.bind.annotation.ResponseStatus
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "product")
data class ProductModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var barcode:String,

    @Column
    var quantity: Int,

    @Column
    var price: BigDecimal,

    @Column
    var isActive: Boolean,

    @Column
    var createAt: LocalDateTime?,

    @Column
    var updateAt: LocalDateTime?,

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category:CategoryModel? = null





)