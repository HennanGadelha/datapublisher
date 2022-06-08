package com.datapublisher.integration

import com.datapublisher.integration.dto.ChamadosResponse

interface FlaskApi {

    suspend fun listarTodosChamados() : Array<ChamadosResponse>?
}