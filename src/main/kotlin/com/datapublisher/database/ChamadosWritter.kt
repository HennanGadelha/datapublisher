package com.datapublisher.database

import com.datapublisher.ChamadoBussiness
import com.datapublisher.config.DataPublisherLogger
import com.datapublisher.config.logger
import com.datapublisher.integration.dto.ChamadosResponse
import io.reactivex.Single
import io.vertx.reactivex.pgclient.PgPool
import io.vertx.reactivex.sqlclient.Tuple
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ChamadosWritter(@Inject val db: PgPool) : DataPublisherLogger {


//    fun insertAll(chamados: List<ChamadoBussiness>) {
//        chamados.map { chamado
//            -> this.insert(chamado) }
//    }

    fun insert(chamado: ChamadosResponse) : Single<Boolean>{

        val params = arrayOf(
            chamado.id,
            chamado.ano,
            chamado.mes,
            chamado.processo_numero,
            chamado.solicitacao_data,
            chamado.solicitacao_hora,
            chamado.solicitacao_descricao,
            chamado.solicitacao_regional,
            chamado.solicitacao_bairro,
            chamado.solicitacao_localidade,
            chamado.solicitacao_endereco,
            chamado.solicitacao_roteiro,
            chamado.rpa_codigo,
            chamado.rpa_nome,
            chamado.solicitacao_microregiao,
            chamado.solicitacao_plantao,
            chamado.processo_situacao,
            chamado.processo_tipo,
            chamado.processo_origem,
            chamado.processo_solicitacao_colocacao_de_lonas_plasticas,
            chamado.processo_solicitacao_vistoria,
            chamado.endUnico
        )

        val sql = "INSERT INTO chamados " +
                "(id, ano, mes, processo_numero, solicitacao_data, solicitacao_hora, solicitacao_descricao, " +
                "solicitacao_regional, solicitacao_bairro, solicitacao_localidade, solicitacao_endereco, " +
                "solicitacao_roteiro, rpa_codigo, rpa_nome, solicitacao_microregiao, solicitacao_plantao, " +
                "processo_situacao, processo_tipo, processo_origem, solicitacao_lonas_plasticas, " +
                "solicitacao_vistorias, endereco)" +
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