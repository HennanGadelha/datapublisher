package com.datapublisher.controller

import com.datapublisher.ChamadoBussiness
import com.datapublisher.ChamadoService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller
class FlaskApiChamados(@Inject private val service: ChamadoService) {

    @Get("/")
    suspend fun recuperarChamadosFlask() {
        service.persistirChamados()
    }
}