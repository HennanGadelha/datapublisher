package com.datapublisher.controller

import com.datapublisher.ChamadoService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller
class FlaskApiChamados(@Inject private val service: ChamadoService) {

    @Consumes(MediaType.ALL)
    @Get("/")
    suspend fun recuperarChamadosFlask() {
        service.persistirChamados()
    }
}