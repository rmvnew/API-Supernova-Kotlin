package com.supernova.security

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.supernova.controller.request.LoginRequest
import com.supernova.exception.AuthException
import com.supernova.repository.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter(
    authenticationManager: AuthenticationManager,
    private val userRepository: UserRepository,
    private val jwtUtil: JwtUtil
) : UsernamePasswordAuthenticationFilter(authenticationManager) {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {

        try {
            val loginRequest = jacksonObjectMapper().readValue(request.inputStream, LoginRequest::class.java)
            val id = userRepository.findByEmail(loginRequest.email)?.id
            val authToken = UsernamePasswordAuthenticationToken(id, loginRequest.password)
            return authenticationManager.authenticate(authToken)
        } catch (ex: Exception) {
            throw AuthException("Falha ao autenticar","999")
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {

       val id = (authResult.principal as UserCustomDetails).id
        val token = jwtUtil.generateToken(id)
        response.addHeader("Authorization","Bearer $token")

    }

}