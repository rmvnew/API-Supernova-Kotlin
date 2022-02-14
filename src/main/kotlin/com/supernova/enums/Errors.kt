package com.supernova.enums

enum class Errors(val code: String, val message: String) {

    SYS001("SYS-001", "name is already registered in the database"),
    SYS002("SYS-002", "the minimum length for name is 3 characters"),
    SYS003("SYS-003", "the maximum name length is 100 characters"),

    CA001("CA-001", "Category [%s] not exists"),
    CA002("CA-002", "the category name cannot be blank"),

    PO001("PO-001", "Category [%s] not exists"),
    PO002("PO-002", "the category name cannot be blank"),




    ML001("ML-001", "Invalid request"),
    ML101("ML-101", "Book [%s] not exists"),
    ML102("ML-102", "Cannot update or delete book with status [%s]"),
    ML201("ML-201", "Customer [%s] not exists")

}