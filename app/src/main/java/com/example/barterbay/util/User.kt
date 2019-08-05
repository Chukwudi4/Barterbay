package com.example.barterbay.util


class User(_username: String = "john"){
    private var username = ""

    init{
        username = _username
    }

    fun login(username: String, password: String): Boolean{
        if(username == password) return true
        setSession()
        return false
    }

    private fun setSession(){

    }
}