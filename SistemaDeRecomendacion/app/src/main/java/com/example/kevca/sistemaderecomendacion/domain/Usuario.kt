package com.example.kevca.sistemaderecomendacion.domain

/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
data class Usuario(
        var id: Int,
        var nombre: String,
        var imageUrl: String,
        var email: String,
        var password: String,
        var tipo: Int
){
    companion object {
        val ADMIN = 0
        val USER = 1
    }
}