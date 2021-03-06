package com.supernova.enums

enum class Errors(val code: String, val message: String) {

//    Sistema
    SYS001("SYS-001", "name is already registered in the database"),
    SYS002("SYS-002", "the minimum length for name is 3 characters"),
    SYS003("SYS-003", "the maximum name length is 100 characters"),
    SYS004("SYS-004", "found item is inactive"),
    SYS200("SYS-200", "the name cannot contain special characters"),

//    Categories
    CA001("CA-001", "Category [%s] not exists"),
    CA002("CA-002", "the category name cannot be blank"),

//    Product
    PO001("PO-001", "Product [%s] not exists"),
    PO002("PO-002", "the category name cannot be blank"),

//    Address
    AD001("AD-001", "Address [%s] not exists"),
    AD002("CA-002", "the field cannot be blank"),

//    Phone
    PH001("PH-001", "Phone [%s] not exists"),

    ML001("ML-001", "Invalid request"),
    ML101("ML-101", "Book [%s] not exists"),
    ML102("ML-102", "Cannot update or delete book with status [%s]"),
    ML201("ML-201", "Customer [%s] not exists")

}