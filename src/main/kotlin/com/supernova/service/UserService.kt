package com.supernova.service

import com.supernova.controller.request.PostUserRequest
import com.supernova.extension.toUserModel
import com.supernova.repository.AddressRepository
import com.supernova.repository.PhoneRepository
import com.supernova.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val addressRepository: AddressRepository,
    private val phoneRepository: PhoneRepository,
    private val bCrypt: BCryptPasswordEncoder
) {
    fun create(userRequest: PostUserRequest) {
        val user = userRequest.toUserModel(addressRepository, phoneRepository)
        user.password = bCrypt.encode(user.password)
        userRepository.save(user)
    }

}
