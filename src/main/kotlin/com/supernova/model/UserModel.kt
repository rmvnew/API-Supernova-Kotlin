package com.supernova.model

import com.supernova.enums.UserProfile
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "user")
data class UserModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var register:String,

    @Column
    var email:String,

    @Column
    var password: String,

    @Column
    var profile: String,

    @Column
    var isActive: Boolean,

    @Column
    var createAt: LocalDateTime?,

    @Column
    var updateAt: LocalDateTime?,

    @ManyToOne
    @JoinColumn(name = "address_id")
    var address: AddressModel? = null,

    @ManyToOne
    @JoinColumn(name = "phone_id")
    var phone: PhoneModel? = null,

//    @Column(name = "role")
//    @Enumerated(EnumType.STRING)
//    @ElementCollection(targetClass = Profile::class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_roles",joinColumns = [JoinColumn(name = "user_id")])
//    var roles: Set<Profile> = setOf()




)