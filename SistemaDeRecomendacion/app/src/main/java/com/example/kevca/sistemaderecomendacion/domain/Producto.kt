package com.example.kevca.sistemaderecomendacion.domain

/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
data class Producto constructor(
                                var id: Int,
                                var nombre: String,
                                var imageUrl: String,
                                var precio: Float,
                                var cantidad: Int){
constructor(p: Producto, cantidad: Int) : this(p.id, p.nombre, p.imageUrl, p.precio, cantidad)
}