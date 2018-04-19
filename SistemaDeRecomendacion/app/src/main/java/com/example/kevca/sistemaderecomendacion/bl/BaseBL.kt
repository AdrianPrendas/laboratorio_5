package com.example.kevca.sistemaderecomendacion.bl

/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
interface BaseBL<K,T>{
    fun create(obj: T): T
    fun read(key: K): T?
    fun readAll(): List<T>
    fun update(obj: T): T?
    fun delete(key: K): T?
}