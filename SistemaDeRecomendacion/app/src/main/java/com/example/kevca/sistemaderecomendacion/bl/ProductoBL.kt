package com.example.kevca.sistemaderecomendacion.bl
import com.example.kevca.sistemaderecomendacion.domain.Producto
import java.util.ArrayList
import java.util.Hashtable

/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
class ProductoBL: BaseBL<Int, Producto> {

    override fun create(obj: Producto): Producto {
        hashTable[obj.id] = obj
        return obj
    }

    override fun read(key: Int): Producto? {
        return hashTable[key]
    }

    override fun readAll(): List<Producto> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Producto): Producto? {
        hashTable[obj.id]?.let{
            hashTable[it.id] = obj
        }
        return hashTable[obj.id]
    }

    override fun delete(key: Int): Producto?{
        return hashTable.remove(key)
    }

    init{
        hashTable[0] = Producto(0, "Laptop MSI", "", 505000.toFloat(), 10)
        hashTable[1] = Producto(1, "Desktop MSI", "", 699000.toFloat(), 5)
        hashTable[2] = Producto(2, "Teclado Mecanico Rayzer", "", 35900.toFloat(),20)
        hashTable[3] = Producto(3, "Mouse Rayzer", "", 25500.toFloat(),20)
        hashTable[4] = Producto(4, "Desktop Alienware", "",1000000.toFloat(),3)
        hashTable[5] = Producto(5, "Laptop Alienware", "",575900.toFloat(),4)
        hashTable[6] = Producto(6, "Router DLINK", "", 22500.toFloat(),8)
        hashTable[7] = Producto(7, "Router LINKSYS", "", 25000.toFloat(),10)
        hashTable[8] = Producto(8, "Parlantes THONET & VANDER", "", 43200.toFloat(),5)
        hashTable[9] = Producto(9, "Joystick de palanca", "", 15500.toFloat(),5)
        hashTable[10] = Producto(10, "Joystick de xbox", "",12000.toFloat(),10)
        hashTable[11] = Producto(11, "Joystick de xbox 360", "",27300.toFloat(),7)
        hashTable[12] = Producto(12, "Joystick de play 3", "",47400.toFloat(),3)
    }
    private object Holder { val INSTANCE = ProductoBL() }
    companion object {
        val hashTable = Hashtable<Int, Producto>()
        val instance : ProductoBL by lazy{ Holder.INSTANCE }
    }
}
