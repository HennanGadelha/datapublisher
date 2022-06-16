package com.datapublisher.integration

import com.datapublisher.ChamadoBussiness
import com.datapublisher.config.DataPublisherLogger
import com.datapublisher.config.logger
import com.datapublisher.integration.dto.ChamadosResponse
import com.fasterxml.jackson.core.type.TypeReference
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.reactor.http.client.ReactorHttpClient
import jakarta.inject.Singleton
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactive.collect
import java.time.Duration
import java.time.Instant
import io.micronaut.core.type.Argument;
import io.reactivex.Flowable
import reactor.kotlin.adapter.rxjava.toFlowable

@Singleton
class PlataformFlaskApi(private val client: ReactorHttpClient) : FlaskApi, DataPublisherLogger {

    @Value("\${api-flask.url}")
    private lateinit var endpoint: String
    override suspend fun listarTodosChamados(): List<ChamadosResponse>? {
        val url = endpoint
        logger().info("Retrieve called information at: {}", url)
        val request = HttpRequest.GET<Unit>(url).accept(MediaType.ALL_TYPE)
        val start = Instant.now()
        try {
            val chamados: MutableList<ChamadosResponse> = ArrayList<ChamadosResponse>()

            return client.retrieve(request, chamados::class.java)
                .retry(2)
                .onErrorMap(HttpClientResponseException::class.java) { responseError ->
                    val body = responseError.response.getBody(String::class.java).get()
                    RetrieveFlaskApiException(
                        "Error retrieving flask api Status: ${responseError.status.code}, response -> $body",
                        responseError
                    )
                }.doFinally { signal ->
                    logger().info(
                        "Finished fetching flask api ({}) with signal ({}) after {}ms",
                        signal,
                        Duration.between(start, Instant.now()).toMillis()
                    )
                }.awaitSingle()

        } catch (ex: Exception) {
            logger().warn("Error retrieving flask api, ignoring", ex)
            return null
        }
    }

    override suspend fun ocorrenciasPorBairro(): List<ChamadosResponse>? {
        val url = "$endpoint/ocorrenciasporbairro"
        logger().info("Retrieve called information at: {}", url)
        val request = HttpRequest.GET<Unit>(url).accept(MediaType.ALL_TYPE)
        val start = Instant.now()
        try {
            val chamados: MutableList<ChamadosResponse> = ArrayList<ChamadosResponse>()

            return client.retrieve(request, chamados::class.java)
                .retry(2)
                .onErrorMap(HttpClientResponseException::class.java) { responseError ->
                    val body = responseError.response.getBody(String::class.java).get()
                    RetrieveFlaskApiException(
                        "Error retrieving flask api Status: ${responseError.status.code}, response -> $body",
                        responseError
                    )
                }.doFinally { signal ->
                    logger().info(
                        "Finished fetching flask api ({}) with signal ({}) after {}ms",
                        signal,
                        Duration.between(start, Instant.now()).toMillis()
                    )
                }.awaitSingle()

        } catch (ex: Exception) {
            logger().warn("Error retrieving flask api, ignoring", ex)
            return null
        }
    }

    override suspend fun ocorrenciasPorBairroUltimoAno(): List<ChamadosResponse>? {
        val url = "$endpoint/ocorrenciasbairrosultimoano"
        logger().info("Retrieve called information at: {}", url)
        val request = HttpRequest.GET<Unit>(url).accept(MediaType.ALL_TYPE)
        val start = Instant.now()
        try {
            val chamados: MutableList<ChamadosResponse> = ArrayList<ChamadosResponse>()

            return client.retrieve(request, chamados::class.java)
                .retry(2)
                .onErrorMap(HttpClientResponseException::class.java) { responseError ->
                    val body = responseError.response.getBody(String::class.java).get()
                    RetrieveFlaskApiException(
                        "Error retrieving flask api Status: ${responseError.status.code}, response -> $body",
                        responseError
                    )
                }.doFinally { signal ->
                    logger().info(
                        "Finished fetching flask api ({}) with signal ({}) after {}ms",
                        signal,
                        Duration.between(start, Instant.now()).toMillis()
                    )
                }.awaitSingle()

        } catch (ex: Exception) {
            logger().warn("Error retrieving flask api, ignoring", ex)
            return null
        }
    }

    override suspend fun ocorrenciasUltimoAno(): List<ChamadosResponse>? {
        val url = "$endpoint/ocorrenciasultimoano"
        logger().info("Retrieve called information at: {}", url)
        val request = HttpRequest.GET<Unit>(url).accept(MediaType.ALL_TYPE)
        val start = Instant.now()
        try {
            val chamados: MutableList<ChamadosResponse> = ArrayList<ChamadosResponse>()

            return client.retrieve(request, chamados::class.java)
                .retry(2)
                .onErrorMap(HttpClientResponseException::class.java) { responseError ->
                    val body = responseError.response.getBody(String::class.java).get()
                    RetrieveFlaskApiException(
                        "Error retrieving flask api Status: ${responseError.status.code}, response -> $body",
                        responseError
                    )
                }.doFinally { signal ->
                    logger().info(
                        "Finished fetching flask api ({}) with signal ({}) after {}ms",
                        signal,
                        Duration.between(start, Instant.now()).toMillis()
                    )
                }.awaitSingle()

        } catch (ex: Exception) {
            logger().warn("Error retrieving flask api, ignoring", ex)
            return null
        }
    }
}

class RetrieveFlaskApiException(message: String, cause: Exception) : Exception(message, cause) {
    override fun fillInStackTrace(): Throwable {
        return this
    }
}