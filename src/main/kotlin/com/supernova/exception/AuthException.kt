package com.supernova.exception

class AuthException(override val message:String, val errorCode:String):Exception() {
}