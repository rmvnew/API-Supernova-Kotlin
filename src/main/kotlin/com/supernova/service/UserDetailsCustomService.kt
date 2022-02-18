package com.supernova.service

import com.supernova.exception.AuthException
import com.supernova.repository.UserRepository
import com.supernova.security.UserCustomDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomService(
    private val userRepository: UserRepository
):UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val user = userRepository.findById(id.toInt())
            .orElseThrow { AuthException("Usuário não existe", "999") }
        return  UserCustomDetails(user)
    }
}