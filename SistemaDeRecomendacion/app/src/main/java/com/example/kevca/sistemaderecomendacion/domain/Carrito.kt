package com.example.kevca.sistemaderecomendacion.domain


import com.example.kevca.sistemaderecomendacion.bl.ProductoBL
import com.example.kevca.sistemaderecomendacion.bl.UsuarioBL
import java.util.*

/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
class Carrito(var usuario: Int){
    var hashtableProductos: Hashtable<Int, Producto> = Hashtable()
    var precioTotal: Float = 0.toFloat()

    @Throws(RuntimeException::class)
    fun addProducto(p: Producto){
        ProductoBL.instance.read(p.id)?.let {
            if(it.cantidad - p.cantidad >= 0){
                hashtableProductos[p.id] = p
                precioTotal += p.precio * p.cantidad
                //it.cantidad -= p.cantidad
            }else{
                throw RuntimeException("Error solo existen "+it.cantidad+" elementos y usted requiere "+p.cantidad)
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
                    throw RuntimeException("Error la cantidad del producto excede en " + (it.cantidad - p.cantidad))
                }
            }
        }
    }

    fun pagar(){
        ArrayList(hashtableProductos.values).forEach{ p->
            ProductoBL.instance.read(p.id)?.let{
                it.cantidad -=p.cantidad
            }
        }
        UsuarioBL.instance.read(this.usuario)?.let{
            println("\nEl usuario: "+ it)
            println("Pago un total de: "+precioTotal)
        }

        hashtableProductos = Hashtable()
        precioTotal = 0.toFloat()
    }

    fun toList(): List<Producto>{
        return ArrayList(hashtableProductos.values)
    }


    override fun toString(): String{
        return "{usuario: "+this.usuario +
                ", listaProductos: " + ArrayList(this.hashtableProductos.values).toString()+
                ", precioTotal: "+this.precioTotal +"}"
    }
}