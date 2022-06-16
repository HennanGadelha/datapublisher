package com.datapublisher.controller.flaskapi

import com.datapublisher.ChamadoService
import com.datapublisher.integration.dto.ChamadosResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller
class FlaskApiChamados(@Inject private val service: ChamadoService) {

    @Consumes(MediaType.ALL)
    @Get("/")
    suspend fun recuperarChamadosFlask() = service.listarChamados()


}