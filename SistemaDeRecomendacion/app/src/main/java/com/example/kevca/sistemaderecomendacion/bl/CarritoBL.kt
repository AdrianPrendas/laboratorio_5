package com.example.kevca.sistemaderecomendacion.bl
import com.example.kevca.sistemaderecomendacion.domain.Carrito
import com.example.kevca.sistemaderecomendacion.domain.Producto
import java.util.ArrayList
import java.util.Hashtable


/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
class CarritoBL: BaseBL<Int, Carrito> {

    override fun create(obj: Carrito): Carrito {
        hashTable[obj.usuario] = obj
        return obj
    }

    override fun read(key: Int): Carrito? {
        return hashTable[key]
    }

    override fun readAll(): List<Carrito> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Carrito): Carrito? {
        hashTable[obj.usuario]?.let{
            hashTable[it.usuario] = obj
        }
        return hashTable[obj.usuario]
    }

    override fun delete(key: Int): Carrito?{
        return hashTable.remove(key)
    }

    init{
        //USERS
        try {
            hashTable[813156487] = Carrito(813156487);
            hashTable[908069482] = Carrito(908069482);
            hashTable[118510669] = Carrito(118510669);
            hashTable[494658212] = Carrito(494658212);
            hashTable[673424513] = Carrito(673424513);
            hashTable[876415060] = Carrito(876415060);
            hashTable[984357664] = Carrito(984357664);
            hashTable[964465378] = Carrito(964465378);
            hashTable[769438762] = Carrito(769438762);
            hashTable[368377663] = Carrito(368377663);
            hashTable[304830405] = Carrito(304830405);
            hashTable[114830575] = Carrito(114830575);
            hashTable[604140420] = Carrito(604140420);
            hashTable[0] = Carrito(0);

            hashTable[964465378] = Carrito(964465378)

            ProductoBL.instance.read(0)?.let {
                hashTable[964465378]?.addProducto(Producto(it,1))
            }
            /*ProductoBL.instance.read(1)?.let {
                hashTable[964465378]?.addProducto(Producto(it,1))
            }
            ProductoBL.instance.read(2)?.let {
                hashTable[964465378]?.addProducto(Producto(it,2))
            }*/

            hashTable[769438762] = Carrito(769438762)

            ProductoBL.instance.read(3)?.let {
                hashTable[769438762]?.addProducto(Producto(it,3))
            }
            /*ProductoBL.instance.read(4)?.let {
                hashTable[769438762]?.addProducto(Producto(it,1))
            }
            ProductoBL.instance.read(5)?.let {
                hashTable[769438762]?.addProducto(Producto(it,1))
            }*/

            hashTable[368377663] = Carrito(368377663)

            ProductoBL.instance.read(5)?.let {
                hashTable[368377663]?.addProducto(Producto(it,1))
            }
            /*ProductoBL.instance.read(6)?.let {
                hashTable[368377663]?.addProducto(Producto(it,1))
            }
            ProductoBL.instance.read(7)?.let {
                hashTable[368377663]?.addProducto(Producto(it,1))
            }*/

            //ADMINS
            hashTable[304830405] = Carrito(304830405)
            hashTable[114830575] = Carrito(114830575)
            hashTable[604140420] = Carrito(604140420)

            ProductoBL.instance.read(0)?.let {
                hashTable[604140420]?.addProducto(Producto(it,1))
            }

            hashTable[0] = Carrito(0)
            ProductoBL.instance.read(0)?.let {
                hashTable[0]?.addProducto(Producto(it,1))
            }
            ProductoBL.instance.read(6)?.let {
                hashTable[0]?.addProducto(Producto(it,1))
            }
            ProductoBL.instance.read(7)?.let {
                hashTable[0]?.addProducto(Producto(it,1))
            }
        }catch (e: RuntimeException){println(e.message)}
    }
    private object Holder { val INSTANCE = CarritoBL() }
    companion object {
        val hashTable = Hashtable<Int, Carrito>()
        val instance : CarritoBL by lazy{ Holder.INSTANCE }
    }
}
