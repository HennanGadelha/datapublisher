package com.datapublisher.integration.dto

import com.datapublisher.ChamadoBussiness
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import io.micronaut.core.annotation.Introspected
import java.util.UUID

@Introspected
data class ChamadosResponse(
    val id : UUID = UUID.randomUUID(),
    val ano: Int,
    val mes: String?,
    val processo_numero: Number?,
    val solicitacao_data: String?,
    val solicitacao_hora: String?,
    val solicitacao_descricao: String?,
    val solicitacao_regional: String?,
    val solicitacao_bairro: String?,
    val solicitacao_localidade: String?,
    val solicitacao_endereco: String?,
    val solicitacao_roteiro: String?,
    val rpa_codigo: String?,
    val rpa_nome: String?,
    val solicitacao_microregiao: String?,
    val solicitacao_plantao: String?,
    val processo_situacao: String?,
    val processo_tipo: String?,
    val processo_origem: String?,
    val processo_solicitacao_colocacao_de_lonas_plasticas: Int,
    val processo_solicitacao_vistoria: String?,
    val endUnico: String?

) {
    fun toChamadoBussiness() =
        ChamadoBussiness(
            ano = this.ano,
            mes = this.mes,
            processoNumero = this.processo_numero,
            solicitacaoData = this.solicitacao_data,
            solicitacaoHora = this.solicitacao_hora,
            solicitacaoDescricao = this.solicitacao_descricao     ,
            solicitacaoRegional = this.solicitacao_regional,
            solicitacaoBairro = this.solicitacao_bairro,
            solicitacaoLocalidade = this.solicitacao_localidade,
            solicitacaoEndereco = this.solicitacao_endereco,
            solicitacaoRoteiro = this.solicitacao_roteiro,
            rpaCodigo = this.rpa_codigo,
            rpaNome = this.rpa_nome,
            solicitacaoMicroregiao = this.solicitacao_microregiao,
            solicitacaoPlantao = this.solicitacao_plantao,
            solicitacaoSituacao = this.processo_situacao,
            processoTipo = this.processo_tipo,
            processoOrigem = this.processo_origem,
            processoSolicitacaoColocacaoDeLonasPlasticas = this.processo_solicitacao_colocacao_de_lonas_plasticas,
            processoSolicitacaoDeVistorias = this.processo_solicitacao_vistoria,
            endUnico = this.endUnico
        )
}
