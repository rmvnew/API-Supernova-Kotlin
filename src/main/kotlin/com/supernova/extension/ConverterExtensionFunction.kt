package com.supernova.extension

import com.supernova.controller.request.*
import com.supernova.controller.response.AddressResponse
import com.supernova.controller.response.CategoryResponse
import com.supernova.controller.response.ProductResponse
import com.supernova.enums.Errors
import com.supernova.exception.BadRequestException
import com.supernova.model.*
import com.supernova.repository.AddressRepository
import com.supernova.repository.PhoneRepository
import com.supernova.service.CategoryService
import com.supernova.util.max_length_name
import com.supernova.util.min_length_name
import java.time.LocalDateTime

/**
 * Categories
 */

fun PostCategoryRequest.toCategoryModel(): CategoryModel {
    return CategoryModel(
        name = this.name,
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null

    )
}

fun CategoryModel.toResponse(): CategoryResponse {
    return CategoryResponse(
        id = this.id,
        name = this.name,
        isActive = this.isActive,
        createAt = this.createAt,
        updateAt = this.updateAt
    )
}

fun PutCategoryRequest.toCategoryModel(category: CategoryModel): CategoryModel {
    return CategoryModel(
        id = category.id,
        name = this.name,
        isActive = category.isActive,
        createAt = category.createAt,
        updateAt = LocalDateTime.now()

    )
}

/**
 * String
 */

fun String.validLength() {

    val nameLength = this.trim().length

    when {
        nameLength < min_length_name -> throw BadRequestException(Errors.SYS002.message, Errors.SYS002.code)
        nameLength > max_length_name -> throw BadRequestException(Errors.SYS003.message, Errors.SYS003.code)
    }

}




/**
 * product
 */


fun PostProductRequest.toProductModel(
    categoryService: CategoryService
): ProductModel {

    return ProductModel(

        name = this.name,
        barcode = this.barcode,
        quantity = this.quantity,
        price = this.price,
        category = categoryService.findById(this.categoryId),
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null

    )
}

fun ProductModel.toResponse(): ProductResponse {
    return ProductResponse(
        id = this.id,
        name = this.name,
        barcode = this.barcode,
        quantity = this.quantity,
        price = this.price,
        isActive = this.isActive,
        createAt = this.createAt,
        updateAt = this.updateAt,
        caregory = this.category
    )
}

fun PutProductRequest.toProductModel(productModel:ProductModel, categoryService: CategoryService):ProductModel{
    return ProductModel(
        id = productModel.id,
        name = this.name,
        barcode = this.barcode,
        quantity = this.quantity,
        price = this.price,
        category = categoryService.findById(this.categoryId),
        isActive = productModel.isActive,
        createAt = productModel.createAt,
        updateAt = LocalDateTime.now()
    )
}


/**
 * Address
 */


fun PostAddressRequest.toAddressModel():AddressModel{
    return AddressModel(

        zipCode = this.zipCode,
        state = this.state,
        city = this.city,
        district = this.district,
        street = this.street,
        number = this.number,
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null

    )
}

fun AddressModel.toResponse():AddressResponse{
    return AddressResponse(
        id = this.id,
        zipCode = this.zipCode,
        state = this.state,
        city = this.city,
        district = this.district,
        street = this.street,
        number = this.number,
        isActive = this.isActive,
        createAt = this.createAt,
        updateAt = this.updateAt
    )
}

fun PutAddressRequest.toAddressModel(addressModel: AddressModel):AddressModel{
    return AddressModel(
        id = addressModel.id,
        zipCode = this.zipCode,
        street = this.street,
        state = this.state,
        city = this.city,
        district = this.district,
        number = this.number,
        isActive = addressModel.isActive,
        createAt = addressModel.createAt,
        updateAt = LocalDateTime.now()
    )
}

/**
 * Phone
 */

fun PostPhoneRequest.toPhoneModel():PhoneModel{
    return PhoneModel(
        phone = this.phone,
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null
    )
}

fun PutPhoneRequest.toPhoneModel(phoneModel: PhoneModel):PhoneModel{
    return  PhoneModel(
        id = phoneModel.id,
        phone = this.phone,
        isActive = phoneModel.isActive,
        createAt = phoneModel.createAt,
        updateAt = LocalDateTime.now()
    )
}


/**
 * User
 */


fun PostUserRequest.toUserModel(
    addressRepository: AddressRepository,
    phoneRepository: PhoneRepository
):UserModel{

    val phone = PhoneModel(
        phone = this.phone.phone,
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null
    )

    phoneRepository.save(phone)

    val address = AddressModel(
        zipCode = this.address.zipCode,
        state = this.address.state,
        city = this.address.city,
        district = this.address.district,
        street = this.address.street,
        number = this.address.number,
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null
    )

    addressRepository.save(address)

    return UserModel(
        name = this.name,
        register = this.register,
        email = this.email,
        password = this.password,
        profile = this.profile,
        isActive = true,
        createAt = LocalDateTime.now(),
        updateAt = null,
        address = address,
        phone = phone

    )
}