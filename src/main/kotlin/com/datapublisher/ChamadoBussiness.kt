package com.datapublisher

import java.util.UUID

data class ChamadoBussiness(
    val id: String = UUID.randomUUID().toString(),
    val ano: Int?,
    val mes: String?,
    val processoNumero: Number?,
    val solicitacaoData: String?,
    val solicitacaoHora: String?,
    val solicitacaoDescricao: String?,
    val solicitacaoRegional: String?,
    val solicitacaoBairro: String?,
    val solicitacaoLocalidade: String?,
    val solicitacaoEndereco: String?,
    val solicitacaoRoteiro: String?,
    val rpaCodigo: String?,
    val rpaNome: String?,
    val solicitacaoMicroregiao: String?,
    val solicitacaoPlantao: String?,
    val solicitacaoSituacao: String?,
    val processoTipo: String?,
    val processoOrigem: String?,
    val processoSolicitacaoColocacaoDeLonasPlasticas: Int,
    val processoSolicitacaoDeVistorias: String?,
    val endUnico: String?
)

