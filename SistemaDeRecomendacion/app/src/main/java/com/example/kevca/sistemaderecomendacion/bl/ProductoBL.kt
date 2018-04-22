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
        hashTable[0] = Producto(0, "Laptop MSI", "laptop_msi", 505000.toFloat(), 10)
        hashTable[1] = Producto(1, "Desktop MSI", "desktop_msi", 699000.toFloat(), 5)
        hashTable[2] = Producto(2, "Teclado Mecanico Rayzer", "teclado_mecanico_rayzer", 35900.toFloat(),20)
        hashTable[3] = Producto(3, "Mouse Rayzer", "mouse_rayzer", 25500.toFloat(),20)
        hashTable[4] = Producto(4, "Desktop Alienware", "desktop_alienware",1000000.toFloat(),3)
        hashTable[5] = Producto(5, "Laptop Alienware", "laptop_alienware",575900.toFloat(),4)
        hashTable[6] = Producto(6, "Router DLINK", "router_dlink", 22500.toFloat(),8)
        hashTable[7] = Producto(7, "Router LINKSYS", "router_linksys", 25000.toFloat(),10)
        hashTable[8] = Producto(8, "Parlantes THONET & VANDER", "parlantes", 43200.toFloat(),5)
        hashTable[9] = Producto(9, "Joystick de palanca", "joystick_palanca", 15500.toFloat(),5)
        hashTable[10] = Producto(10, "Joystick de xbox", "joystick_xbox",12000.toFloat(),10)
        hashTable[11] = Producto(11, "Joystick de xbox 360", "joystick_xbox360",27300.toFloat(),7)
        hashTable[12] = Producto(12, "Joystick de play 3", "joystick_play3",47400.toFloat(),3)
    }
    private object Holder { val INSTANCE = ProductoBL() }
    companion object {
        val hashTable = Hashtable<Int, Producto>()
        val instance : ProductoBL by lazy{ Holder.INSTANCE }
    }
}
