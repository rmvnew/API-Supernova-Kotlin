package com.supernova.exception

class NotFoundException(override  val message:String, val errorCode:String):Exception() {
}