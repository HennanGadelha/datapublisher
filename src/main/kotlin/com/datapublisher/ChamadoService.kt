package com.datapublisher

import com.datapublisher.database.ChamadosWritter
import com.datapublisher.integration.FlaskApi
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ChamadoService(@Inject val dao: ChamadosWritter, private val flaskApi: FlaskApi) {

    suspend fun persistirChamados(){
        val listaDeChamados = flaskApi.listarTodosChamados()
//        lateinit var listaChamadosBussines: MutableList<ChamadoBussiness>
//        listaDeChamados!!.map { response -> listaChamadosBussines.add(response
//            .toChamadoBussiness())  }
//        dao.insertAll(listaChamadosBussines)
        println("lista de chamados: " + listaDeChamados)
    }

}