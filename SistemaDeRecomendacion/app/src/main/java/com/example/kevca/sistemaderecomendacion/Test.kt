package com.example.kevca.sistemaderecomendacion

import com.example.kevca.sistemaderecomendacion.bl.CarritoBL
import com.example.kevca.sistemaderecomendacion.bl.ProductoBL
import com.example.kevca.sistemaderecomendacion.bl.UsuarioBL
import com.example.kevca.sistemaderecomendacion.domain.Producto


class Test{
    init{
        println("***Lista de Usuarios***")
        UsuarioBL.instance.readAll().forEach { println(it) }

        println("\n***Lista de Productos***")
        ProductoBL.instance.readAll().forEach { println(it) }

        println("\n***Lista de Carritos***")
        CarritoBL.instance.readAll().forEach { println(it) }

        /*ProductoBL.instance.read(0)?.let{
            CarritoBL.instance.read(604140420)?.addProducto(it)
        }*/

        println("\n***Lista de Productos***")
        ProductoBL.instance.readAll().forEach { println(it) }

        CarritoBL.instance.read(604140420)?.pagar();

        println("\n***Lista de Productos***")
        ProductoBL.instance.readAll().forEach { println(it) }

        /*ProductoBL.instance.read(0)?.let{
            var p = Producto(it,2)
            println(p)
        }*/



    }
}

fun main(args: Array<String>){
    Test()
}