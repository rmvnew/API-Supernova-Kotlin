package com.supernova.controller

import com.supernova.controller.request.PostUserRequest
import com.supernova.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody userRequest: PostUserRequest){
        userService.create(userRequest)
    }

}