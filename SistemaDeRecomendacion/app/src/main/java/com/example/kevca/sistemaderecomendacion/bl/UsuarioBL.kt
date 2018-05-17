package com.example.kevca.sistemaderecomendacion.bl

import com.example.kevca.sistemaderecomendacion.domain.Usuario
import java.util.ArrayList
import java.util.Hashtable

/**
 * Created by _Adrian_Prendas_ on 18/04/2018.
 */
class UsuarioBL: BaseBL<Int, Usuario> {

    override fun create(obj: Usuario): Usuario {
        hashTable[obj.id] = obj
        return obj
    }

    override fun read(key: Int): Usuario? {
        return hashTable[key]
    }

    override fun readAll(): List<Usuario> {
        return ArrayList(hashTable.values)
    }

    override fun update(obj: Usuario): Usuario? {
        hashTable[obj.id]?.let{
            hashTable[it.id] = obj
        }
        return hashTable[obj.id]
    }

    override fun delete(key: Int): Usuario?{
        return hashTable.remove(key)
    }

    init{
        hashTable[813156487] = Usuario(813156487, "Angel Yvanes Gerardo", "persona1", "angel.yvanes.gerardo@una.ac.cr", "angel",Usuario.USER)
        hashTable[908069482] = Usuario(908069482, "Carlos Asencio Ysidro", "persona2", "carlos.asencio.ysidro@una.ac.cr", "carlos",Usuario.USER)
        hashTable[118510669] = Usuario(118510669, "Emiliano Sepulbeda Troche", "persona3", "emiliano.sepulbeda.troche@una.ac.cr", "emiliano",Usuario.USER)
        hashTable[494658212] = Usuario(494658212, "Santino Peredo Dongu", "persona4", "santino.peredo.dongu@una.ac.cr", "santino",Usuario.USER)
        hashTable[673424513] = Usuario(673424513, "Tomas Velasco Clemente", "persona5", "tomas.velasco.clemente@una.ac.cr","tomas",Usuario.USER)
        hashTable[876415060] = Usuario(876415060, "Benjamin Covos Brusiaga", "persona6", "benjamin.covos.brusiaga@una.ac.cr", "benjamin",Usuario.USER)
        hashTable[984357664] = Usuario(984357664, "Gael Mancilla Moia", "persona7", "gael.mancilla.moia@una.ac.cr", "gael",Usuario.USER)
        hashTable[964465378] = Usuario(964465378, "Emmanuel Canchola Espejo", "persona8", "emmanuel.canchola.espejo@una.ac.cr", "emmanuel",Usuario.USER)
        hashTable[769438762] = Usuario(769438762, "Dylan Montecillo Balderas", "persona9", "dylan.montecillo.balderas@una.ac.cr", "dylan",Usuario.USER)
        hashTable[368377663] = Usuario(368377663, "Emiliano Aguado Sifuentes", "persona10", "emiliano.aguado.sifuentes@una.ac.cr", "emiliano",Usuario.USER)
        hashTable[304830405] = Usuario(304830405, "Esteban Montero Fonseca", "esteban","esteban.montero.fonseca@est.una.ac.cr", "esteban",Usuario.ADMIN)
        hashTable[114830575] = Usuario(114830575, "Kevin Calderon Rodriguez", "kevin","kevin.calderon.rodriguez@est.una.ac.cr", "kevin",Usuario.ADMIN)
        hashTable[604140420] = Usuario(604140420, "Adrian prendas Araya", "adrian","adrian.prendas.araya@est.una.ac.cr", "adrian",Usuario.ADMIN)
        hashTable[0] = Usuario(0, "admin", "","admin", "admin",Usuario.ADMIN)
    }
    private object Holder { val INSTANCE = UsuarioBL() }
    companion object {
        val hashTable = Hashtable<Int, Usuario>()
        val instance : UsuarioBL by lazy{ Holder.INSTANCE }
        var session = 0
    }
}
