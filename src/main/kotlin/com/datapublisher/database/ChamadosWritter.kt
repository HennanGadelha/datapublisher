package com.datapublisher.database

import com.datapublisher.ChamadoBussiness
import com.datapublisher.config.DataPublisherLogger
import com.datapublisher.config.logger
import io.reactivex.Single
import io.vertx.reactivex.pgclient.PgPool
import io.vertx.reactivex.sqlclient.Tuple
import jakarta.inject.Inject

class ChamadosWritter(@Inject val db: PgPool) : DataPublisherLogger {

    fun insert(chamado: ChamadoBussiness) : Single<Boolean>{

        val params = arrayOf(
            chamado.id,
            chamado.ano,
            chamado.mes,
            chamado.processoNumero,
            chamado.solicitacaoData,
            chamado.solicitacaoHora,
            chamado.solicitacaoDescricao,
            chamado.solicitacaoRegional,
            chamado.solicitacaoBairro,
            chamado.solicitacaoLocalidade,
            chamado.solicitacaoEndereco,
            chamado.solicitacaoRoteiro,
            chamado.rpaCodigo,
            chamado.rpaNome,
            chamado.solicitacaoMicroregiao,
            chamado.solicitacaoPlantao,
            chamado.solicitacaoSituacao,
            chamado.processoTipo,
            chamado.processoOrigem,
            chamado.processoSolicitacaoColocacaoDeLonasPlasticas,
            chamado.processoSolicitacaoDeVistorias,
            chamado.endUnico
        )

        val sql = "INSERT INTO chamados " +
                "(id, ano, mes, processo_numero, solicitacao_data, solicitacao_hora, solicitacao_descricao, " +
                "solicitacao_regional, solicitacao_bairro, solicitacao_localidade, solicitacao_endereco, " +
                "solicitacao_roteiro, rpa_codigo, rpa_nome, solicitacao_microregiao, solicitacao_plantao " +
                "solicitacao_situacao, processo_tipo, processo_origem, solicitcao_lonas_plasticas, " +
                "solicitcao_vistorias, endereco)" +
                "VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, " +
                "$14, $15, $16, $17, $18, $19, $20, $21, $22)"

        val result = db.preparedQuery(sql).rxExecute(Tuple.from(params)).map {
            logger().info("chamado persitido com sucesso. id: ({})", chamado.id)
            true
        }.doOnError{
            logger().info("error ao persitir chamado. id: ({})", chamado.id)
        }
        result.blockingGet()
        return result
    }
}