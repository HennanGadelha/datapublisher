package com.datapublisher.integration.dto

import com.datapublisher.ChamadoBussiness

data class ChamadosResponse(
    val ano: Int,
    val mes: String,
    val processoNumero: Int,
    val solicitacaoData: String,
    val solicitacaoHora: String,
    val solicitacaoDescricao: String,
    val solicitacaoRegional: String,
    val solicitacaoBairro: String,
    val solicitacaoLocalidade: String,
    val solicitacaoEndereco: String,
    val solicitacaoRoteiro: String,
    val rpaCodigo: String,
    val rpaNome: String,
    val solicitacaoMicroregiao: String,
    val solicitacaoPlantao: String,
    val solicitacaoSituacao: String,
    val processoTipo: String,
    val processoOrigem: String,
    val processoSolicitacaoColocacaoDeLonasPlasticas: Int,
    val processoSolicitacaoDeVistorias: String,
    val endUnico: String

) {
    fun toChamadoBussiness() =
        ChamadoBussiness(
            ano = this.ano,
            mes = this.mes,
            processoNumero = this.processoNumero,
            solicitacaoData = this.solicitacaoData,
            solicitacaoHora = this.solicitacaoHora,
            solicitacaoDescricao = this.solicitacaoDescricao,
            solicitacaoRegional = this.solicitacaoRegional,
            solicitacaoBairro = this.solicitacaoBairro,
            solicitacaoLocalidade = this.solicitacaoLocalidade,
            solicitacaoEndereco = this.solicitacaoEndereco,
            solicitacaoRoteiro = this.solicitacaoRoteiro,
            rpaCodigo = this.rpaCodigo,
            rpaNome = this.rpaNome,
            solicitacaoMicroregiao = this.solicitacaoMicroregiao,
            solicitacaoPlantao = this.solicitacaoPlantao,
            solicitacaoSituacao = this.solicitacaoSituacao,
            processoTipo = this.processoTipo,
            processoOrigem = this.processoOrigem,
            processoSolicitacaoColocacaoDeLonasPlasticas = this.processoSolicitacaoColocacaoDeLonasPlasticas,
            processoSolicitacaoDeVistorias = this.processoSolicitacaoDeVistorias,
            endUnico = this.endUnico
        )
}
