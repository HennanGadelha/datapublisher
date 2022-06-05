--liquibase formatted sql
--changeset hennan

CREATE TABLE chamados (
    id TEXT,
    ano INT,
    mes TEXT,
    processo_numero TEXT,
    solicitcao_data TEXT,
    solicitacao_hora TEXT,
    solicitacao_descricao TEXT,
    solicitacao_regional  TEXT,
    solicitacao_bairro TEXT,
    solicitacao_localidade TEXT,
    solicitacao_endereco TEXT,
    solicitacao_roteiro TEXT,
    rpa_codigo TEXT,
    rpa_nome TEXT,
    solicitacao_microregiao TEXT,
    solicitacao_plantao TEXT,
    solicitacao_situacao TEXT,
    processo_tipo TEXT,
    processo_origem TEXT,
    solicitcao_lonas_plasticas INT,
    solicitcao_vistorias INT,
    endereco TEXT,
    PRIMARY KEY (id)
);

