package com.datapublisher

import com.datapublisher.database.ChamadosWritter
import com.datapublisher.integration.FlaskApi
import com.datapublisher.integration.dto.ChamadosResponse
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlin.collections.List

@Singleton
class ChamadoService(@Inject val dao: ChamadosWritter, private val flaskApi: FlaskApi) {

    suspend fun persistirChamados() : List<ChamadosResponse> {
        val responseList = flaskApi.listarTodosChamados()
//        responseList!!.map { response -> println(response) }
//        responseList!!.forEach { response -> println(response) }
        println(responseList!!.size)
        //println("lista de chamados: " + responseList)

        return responseList
    }



}