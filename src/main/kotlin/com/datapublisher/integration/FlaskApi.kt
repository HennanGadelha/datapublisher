package com.datapublisher.integration

import com.datapublisher.integration.dto.ChamadosResponse

interface FlaskApi {

    suspend fun listarTodosChamados() :  List<ChamadosResponse>?

    suspend fun ocorrenciasPorBairro() : List<ChamadosResponse>?

    suspend fun ocorrenciasPorBairroUltimoAno() : List<ChamadosResponse>?

    suspend fun ocorrenciasUltimoAno() : List<ChamadosResponse>?
}