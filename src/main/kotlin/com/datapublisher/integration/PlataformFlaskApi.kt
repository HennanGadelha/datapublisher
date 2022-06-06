package com.datapublisher.integration

import com.datapublisher.ChamadoBussiness
import com.datapublisher.config.DataPublisherLogger
import com.datapublisher.config.logger
import com.datapublisher.integration.dto.ChamadosResponse
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.reactor.http.client.ReactorHttpClient
import jakarta.inject.Singleton
import kotlinx.coroutines.reactive.awaitSingle
import java.time.Duration
import java.time.Instant

@Singleton
class PlataformFlaskApi(private val client: ReactorHttpClient) : FlaskApi, DataPublisherLogger {

    @Value("\${api..url}")
    private lateinit var endpoint: String
    override suspend fun listarTodosChamados():  List<ChamadosResponse>? {
        val url = endpoint
        logger().info("Retrieve called information at: {}", url)
        val request = HttpRequest.GET<Unit>(url)
        val start = Instant.now()
        try {
            return client.retrieve(request, ChamadosResponse::class.java)
                .retry(2)
                .onErrorMap(HttpClientResponseException::class.java) { responseError ->
                    val body = responseError.response.getBody(String::class.java).get()
                    RetrieveFlaskApiException(
                        "Error retrieving flask api Status: ${responseError.status.code}, response: $body",
                        responseError
                    )
                }.doFinally { signal ->
                    logger().info(
                        "Finished fetching flask api ({}) with signal ({}) after {}ms",
                        signal,
                        Duration.between(start, Instant.now()).toMillis()
                    )
                }.collectList().awaitSingle()
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