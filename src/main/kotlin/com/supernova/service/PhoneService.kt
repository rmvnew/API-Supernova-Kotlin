package com.supernova.service

import com.supernova.controller.request.PostPhoneRequest
import com.supernova.controller.request.PutPhoneRequest
import com.supernova.enums.Errors
import com.supernova.exception.NotFoundException
import com.supernova.extension.toPhoneModel
import com.supernova.model.PhoneModel
import com.supernova.repository.PhoneRepository
import com.supernova.validation.ActiveValidate.Companion.validateActive
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PhoneService(
    val phoneRepository: PhoneRepository
) {
    fun create(phoneRequest: PostPhoneRequest) {
        phoneRepository.save(phoneRequest.toPhoneModel())
    }

    fun findAll(pageable: Pageable): Page<PhoneModel> {
        return phoneRepository.findAll(pageable)
    }

    fun findAllActive(pageable: Pageable): Page<PhoneModel> {
        return  phoneRepository.findByIsActiveTrue(pageable)
    }

    fun findById(id: Int): PhoneModel {
        val phone = phoneRepository.findById(id).orElseThrow { NotFoundException(Errors.PH001.message.format(id), Errors.PH001.code) }

        validateActive(phone.isActive)

        return phone

    }

    fun update(id: Int, request: PutPhoneRequest) {

        val phoneSaved = this.findById(id)
        val phone = request.toPhoneModel(phoneSaved)

        phoneRepository.save(phone)

    }

    fun delete(id: Int) {

        val phoneSaved = this.findById(id)

        phoneSaved.isActive = false

        phoneRepository.save(phoneSaved)

    }

}
