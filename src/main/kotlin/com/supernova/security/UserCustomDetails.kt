package com.supernova.security

import com.supernova.model.UserModel
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserCustomDetails(val userModel: UserModel):UserDetails {
    val id:Int = userModel.id!!
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>  = userModel.profile.map { SimpleGrantedAuthority(it.toString()) }.toMutableList()

    override fun getPassword(): String = userModel.password

    override fun getUsername(): String = userModel.id.toString()

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = userModel.isActive == true
}