package com.supernova.service

import com.supernova.controller.request.PostAddressRequest
import com.supernova.controller.request.PutAddressRequest
import com.supernova.enums.Errors
import com.supernova.exception.NotFoundException
import com.supernova.extension.toAddressModel
import com.supernova.model.AddressModel
import com.supernova.repository.AddressRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AddressService(
    val addressRepository: AddressRepository
) {
    fun create(request: PostAddressRequest) {
        addressRepository.save(request.toAddressModel())
    }

    fun findAll(pageable: Pageable): Page<AddressModel> {
        return addressRepository.findAll(pageable)
    }

    fun findAllActive(pageable: Pageable): Page<AddressModel> {
        return addressRepository.findByIsActiveTrue(pageable)
    }

    fun findById(id: Int): AddressModel {
        val address = addressRepository.findById(id).orElseThrow { NotFoundException(Errors.AD001.message, Errors.AD001.code) }

        address.validateActive(address.isActive)

       return  address
    }

    fun update(id: Int, request: PutAddressRequest) {
        val savedAddress = this.findById(id)

        val address = request.toAddressModel(savedAddress)

        addressRepository.save(address)

    }

    fun delete(id: Int) {
        val savedAddress = this.findById(id)

        savedAddress.isActive = false

        addressRepository.save(savedAddress)
    }



}
