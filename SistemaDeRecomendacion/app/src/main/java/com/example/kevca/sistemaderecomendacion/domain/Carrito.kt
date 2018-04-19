package com.example.kevca.sistemaderecomendacion.domain


import com.example.kevca.sistemaderecomendacion.bl.ProductoBL
import java.util.*

/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
data class Carrito(var usuario: Int){
    var hashtableProductos: Hashtable<Int, Producto> = Hashtable()
    var precioTotal: Float = 0.toFloat()

    @Throws(RuntimeException::class)
    fun addProducto(p: Producto){
        ProductoBL.instance.read(p.id)?.let {
            if(it.cantidad-p.cantidad>0){
                hashtableProductos[p.id] = p
                precioTotal += p.precio * p.cantidad
                it.cantidad-=p.cantidad
            }else{
                throw RuntimeException("Error No solo existen "+it.cantidad+" y usted requiere "+p.cantidad)
            }
        }
    }

    @Throws(RuntimeException::class)
    fun removeProducto(p: Producto){
        hashtableProductos[p.id]?.let {
            when{
                it.cantidad - p.cantidad > 0 ->{
                    it.cantidad -= p.cantidad
                    precioTotal -= p.precio * p.cantidad
                }
                it.cantidad - p.cantidad == 0 ->{
                    precioTotal -= p.precio * p.cantidad
                    hashtableProductos.remove(p.id)
                }
                else -> { //it.cantidad - p.cantidad < 0
                    throw RuntimeException("Error No existe esa cantidad en el carrito, solo hay " + it.cantidad)
                }
            }
        }
    }
    fun cleanCarrito(){
        hashtableProductos = Hashtable()
        precioTotal = 0.toFloat()
    }
}