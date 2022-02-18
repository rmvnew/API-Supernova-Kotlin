package com.supernova.repository

import com.supernova.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: JpaRepository<UserModel, Int> {
    abstract fun findByEmail(email: String):UserModel?

}
