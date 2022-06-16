package com.datapublisher

import com.datapublisher.database.ChamadosWritter
import com.datapublisher.integration.FlaskApi
import com.datapublisher.integration.dto.ChamadosResponse
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Inject
import jakarta.inject.Singleton


@Singleton
class ChamadoService(@Inject val dao: ChamadosWritter, private val flaskApi: FlaskApi) {

    
    suspend fun listarChamados(): List<*> {

        val responseList = flaskApi.listarTodosChamados()
        return responseList!!
    }
}