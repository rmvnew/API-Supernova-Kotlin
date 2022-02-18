package com.supernova.security

import com.supernova.exception.AuthException
import com.supernova.service.UserDetailsCustomService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthorizationFilter(
    authenticationManager: AuthenticationManager,
    private val userDetails: UserDetailsCustomService,
    private val jwtUtil: JwtUtil
):BasicAuthenticationFilter(authenticationManager) {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        val authorization = request.getHeader("Authorization")

//        if(authorization != null && authorization.startsWith("Bearer")){
        if(authorization != null && authorization.length > 10 ){
            if(authorization.startsWith("Bearer")) {
                val auth = getAuthentication(authorization.split(" ")[1])
                SecurityContextHolder.getContext().authentication = auth
            }else{
                SecurityContextHolder.getContext().authentication = getAuthentication(authorization)
            }
        }
        chain.doFilter(request,response)
    }

    private fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        if(!jwtUtil.isValidToken(token)){
            throw  AuthException("Token invalido","0999")
        }
        val subject = jwtUtil.getSubject(token)
        val user = userDetails.loadUserByUsername(subject)
        return UsernamePasswordAuthenticationToken(subject,null,user.authorities)
    }


}