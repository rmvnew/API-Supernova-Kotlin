package com.supernova.controller

import com.supernova.controller.request.PostPhoneRequest
import com.supernova.controller.request.PutPhoneRequest
import com.supernova.model.PhoneModel
import com.supernova.service.PhoneService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("phone")
class PhoneController(
    private val phoneService: PhoneService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody phoneRequest: PostPhoneRequest){
        phoneService.create(phoneRequest)
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<PhoneModel>{
       return phoneService.findAll(pageable)
    }

    @GetMapping("/active")
    fun findAllActive(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<PhoneModel>{
       return phoneService.findAllActive(pageable)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int):PhoneModel{
        return phoneService.findById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @Valid @RequestBody request: PutPhoneRequest){
        return phoneService.update(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        phoneService.delete(id)
    }

}