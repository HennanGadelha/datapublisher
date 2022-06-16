package com.datapublisher.controller

import com.datapublisher.ChamadoService
import com.datapublisher.integration.dto.ChamadosResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller
class DataPublishherController(@Inject private val service: ChamadoService) {

    @Get("/chamados")
    suspend fun listAllChamados() = service.listarChamados()


}