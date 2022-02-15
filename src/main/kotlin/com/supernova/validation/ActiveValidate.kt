package com.supernova.validation

import com.supernova.enums.Errors
import com.supernova.exception.NotFoundException

class ActiveValidate {

   companion object{
       fun validateActive(active: Boolean) {

           println(active)
           when{
               !active -> throw NotFoundException(Errors.SYS004.message, Errors.SYS004.code)
           }

       }
   }




}