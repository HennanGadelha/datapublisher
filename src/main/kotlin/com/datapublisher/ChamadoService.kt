package com.datapublisher

import com.datapublisher.integration.FlaskApi

class ChamadoService(private val flaskApi: FlaskApi) {

    suspend fun persistirChamados(){
        val listaDeChamados = flaskApi.listarTodosChamados()
        println("lista de chamados: " + listaDeChamados)
    }

}