package com.supernova.controller

import com.supernova.controller.request.PostAddressRequest
import com.supernova.controller.request.PutAddressRequest
import com.supernova.controller.response.AddressResponse
import com.supernova.extension.toResponse
import com.supernova.model.AddressModel
import com.supernova.service.AddressService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("address")
class AddressController(
    private val addressService: AddressService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody postAddressRequest: PostAddressRequest){
        addressService.create(postAddressRequest)
    }

    @GetMapping()
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<AddressResponse> {
        return addressService.findAll(pageable).map { it.toResponse() }
    }
    @GetMapping("/active")
    fun findAllActive(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<AddressResponse> {
        return addressService.findAllActive(pageable).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int):AddressModel{
       return addressService.findById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id:Int, @RequestBody request: PutAddressRequest){
        addressService.update(id,request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        addressService.delete(id)
    }

}