package com.datapublisher.integration.dto

import com.datapublisher.ChamadoBussiness
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.util.*

//class ChamadosResponseDeserializer : StdDeserializer<ChamadosResponse>(ChamadosResponse::class.java) {
//    override fun deserialize(jp: JsonParser?, ctxt: DeserializationContext?): ChamadosResponse {
//        val node: JsonNode = jp!!.codec.readTree(jp)
//        val ano: Int = (node.get("ano")).asInt()
//        val mes: String = (node.get("mes")).asText()
//        val processo_numero = (node.get("processo_numero")).asDouble()
//        val solicitacao_data = (node.get("solicitacao_data")).asText()
//        val solicitacao_hora = (node.get("solicitacao_hora")).asText()
//        val solicitacao_descricao = (node.get("solicitacao_descricao")).asText()
//        val solicitacao_regional = (node.get("solicitacao_regional")).asText()
//        val solicitacao_bairro = (node.get("solicitacao_bairro")).asText()
//        val solicitacao_localidade = (node.get("solicitacao_localidade")).asText()
//        val solicitacao_endereco = (node.get("solicitacao_endereco")).asText()
//        val solicitacao_roteiro = (node.get("solicitacao_roteiro")).asText()
//        val rpa_codigo = (node.get("rpa_codigo")).asText()
//        val rpa_nome = (node.get("rpa_nome")).asText()
//        val solicitacao_microregiao = (node.get("solicitacao_microregiao")).asText()
//        val solicitacao_plantao  = (node.get("solicitacao_plantao")).asText()
//        val processo_situacao  = (node.get("processo_situacao")).asText()
//        val processo_tipo = (node.get("processo_tipo")).asText()
//        val processo_origem = (node.get("processo_origem")).asText()
//        val processo_solicitacao_colocacao_de_lonas_plasticas = (node.get("processo_solicitacao_colocacao_de_lonas_plasticas")).asInt()
//        val processo_solicitacao_vistoria = (node.get("processo_solicitacao_vistoria")).asText()
//        val endUnico = (node.get("endUnico")).asText()
//
//        return ChamadosResponse(
//            ano = ano,
//            mes = mes,
//            processo_numero = processo_numero,
//            solicitacao_data = solicitacao_data,
//            solicitacao_hora = solicitacao_hora,
//            solicitacao_descricao = solicitacao_descricao,
//            solicitacao_regional = solicitacao_regional,
//            solicitacao_bairro = solicitacao_bairro,
//            solicitacao_localidade = solicitacao_localidade,
//            solicitacao_endereco = solicitacao_endereco,
//            solicitacao_roteiro = solicitacao_roteiro,
//            rpa_codigo = rpa_codigo,
//            rpa_nome = rpa_nome,
//            solicitacao_microregiao = solicitacao_microregiao,
//            solicitacao_plantao = solicitacao_plantao,
//            processo_situacao = processo_situacao,
//            processo_tipo = processo_tipo,
//            processo_origem = processo_origem,
//            processo_solicitacao_colocacao_de_lonas_plasticas = processo_solicitacao_colocacao_de_lonas_plasticas,
//            processo_solicitacao_vistoria =  processo_solicitacao_vistoria,
//            endUnico = endUnico
//        )
//    }
//}
//
//@JsonDeserialize(using = ChamadosResponseDeserializer::class)

data class ChamadosResponse(
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
