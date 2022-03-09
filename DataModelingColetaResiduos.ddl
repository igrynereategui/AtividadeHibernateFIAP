-- Gerado por Oracle SQL Developer Data Modeler 21.1.0.092.1221
--   em:        2022-03-03 16:08:49 GFT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_bairro (
    id_bairro           NUMBER(10) NOT NULL,
    nm_bairro           VARCHAR2(30) NOT NULL,
    t_cidade_id_cidade  NUMBER(10) NOT NULL
);

ALTER TABLE t_bairro ADD CONSTRAINT t_bairro_pk PRIMARY KEY ( id_bairro );

CREATE TABLE t_cidade (
    id_cidade           NUMBER(10) NOT NULL,
    nm_cidade           VARCHAR2(30) NOT NULL,
    t_estado_id_estado  NUMBER(10) NOT NULL
);

ALTER TABLE t_cidade ADD CONSTRAINT t_cidade_pk PRIMARY KEY ( id_cidade );

CREATE TABLE t_coleta (
    id_coleta  NUMBER(10) NOT NULL,
    hr_coleta  DATE NOT NULL
);

ALTER TABLE t_coleta ADD CONSTRAINT t_coleta_pk PRIMARY KEY ( id_coleta );

CREATE TABLE t_end (
    id_end            NUMBER(10) NOT NULL,
    cep_end           NUMBER(8) NOT NULL,
    ds_end            VARCHAR2(30) NOT NULL,
    t_logra_id_logra  NUMBER(10) NOT NULL
);

CREATE UNIQUE INDEX t_end__idx ON
    t_end (
        t_logra_id_logra
    ASC );

ALTER TABLE t_end ADD CONSTRAINT t_end_pk PRIMARY KEY ( id_end );

CREATE TABLE t_estado (
    id_estado  NUMBER(10) NOT NULL,
    nm_estado  VARCHAR2(30)
);

ALTER TABLE t_estado ADD CONSTRAINT t_estado_pk PRIMARY KEY ( id_estado );

CREATE TABLE t_logra (
    id_logra            NUMBER(10) NOT NULL,
    ds_logra            VARCHAR2(30) NOT NULL,
    t_bairro_id_bairro  NUMBER(10) NOT NULL
);

ALTER TABLE t_logra ADD CONSTRAINT t_logra_pk PRIMARY KEY ( id_logra );

CREATE TABLE t_parceiro (
    id_parceiro  NUMBER(10) NOT NULL,
    nm_parceiro  VARCHAR2(30) NOT NULL,
    nr_cnpj      VARCHAR2(20) NOT NULL,
    qtd_desc     NUMBER(3) NOT NULL
);

ALTER TABLE t_parceiro ADD CONSTRAINT t_parceiro_pk PRIMARY KEY ( id_parceiro );

CREATE TABLE t_promo (
    id_promo                NUMBER(10) NOT NULL,
    dt_promo                DATE NOT NULL,
    t_parceiro_id_parceiro  NUMBER(10) NOT NULL
);

ALTER TABLE t_promo ADD CONSTRAINT t_promo_pk PRIMARY KEY ( id_promo,
                                                            t_parceiro_id_parceiro );

CREATE TABLE t_relatorio (
    id_relat  NUMBER(10) NOT NULL,
    nm_relat  VARCHAR2(30) NOT NULL
);

ALTER TABLE t_relatorio ADD CONSTRAINT t_relatorio_pk PRIMARY KEY ( id_relat );

CREATE TABLE t_servico (
    id_serv                         NUMBER(10) NOT NULL,
    dt_serv                         DATE NOT NULL,
    t_tp_serv_id_tp_serv            NUMBER(10) NOT NULL,
    t_promo_id_promo                NUMBER(10) NOT NULL,
    t_promo_t_parceiro_id_parceiro  NUMBER(10) NOT NULL,
    t_user_id_user                  NUMBER(10) NOT NULL
);

CREATE UNIQUE INDEX t_servico__idx ON
    t_servico (
        t_promo_id_promo
    ASC,
        t_promo_t_parceiro_id_parceiro
    ASC );

ALTER TABLE t_servico
    ADD CONSTRAINT t_servico_pk PRIMARY KEY ( id_serv,
                                              t_tp_serv_id_tp_serv,
                                              t_user_id_user );

CREATE TABLE t_tp_resid (
    id_tp_resid         NUMBER(10) NOT NULL,
    nm_resid            VARCHAR2(30) NOT NULL,
    t_coleta_id_coleta  NUMBER(10) NOT NULL
);

ALTER TABLE t_tp_resid ADD CONSTRAINT t_tp_resid_pk PRIMARY KEY ( id_tp_resid,
                                                                  t_coleta_id_coleta );

CREATE TABLE t_tp_serv (
    id_tp_serv            NUMBER(10) NOT NULL,
    nm_tp_serv            VARCHAR2(30) NOT NULL,
    t_coleta_id_coleta    NUMBER(10) NOT NULL,
    t_relatorio_id_relat  NUMBER(10) NOT NULL
);

CREATE UNIQUE INDEX t_tp_serv__idx ON
    t_tp_serv (
        t_coleta_id_coleta
    ASC );

CREATE UNIQUE INDEX t_tp_serv__idxv1 ON
    t_tp_serv (
        t_relatorio_id_relat
    ASC );

ALTER TABLE t_tp_serv ADD CONSTRAINT t_tp_serv_pk PRIMARY KEY ( id_tp_serv );

CREATE TABLE t_user (
    id_user                 NUMBER(10) NOT NULL,
    qnt_residentes          NUMBER(10) NOT NULL,
    t_end_id_end            NUMBER(10) NOT NULL,
    t_user_pf_t_user_pf_id  NUMBER NOT NULL,
    t_user_pj_t_user_pj_id  NUMBER NOT NULL
);

ALTER TABLE t_user ADD CONSTRAINT t_user_pk PRIMARY KEY ( id_user );

CREATE TABLE t_user_pf (
    nm_user       VARCHAR2(50) NOT NULL,
    nr_cpf        VARCHAR2(20) NOT NULL,
    nr_idade      NUMBER(3) NOT NULL,
    t_user_pf_id  NUMBER NOT NULL
);

ALTER TABLE t_user_pf ADD CONSTRAINT t_user_pf_pk PRIMARY KEY ( t_user_pf_id );

CREATE TABLE t_user_pj (
    nm_empresa    VARCHAR2(30) NOT NULL,
    nr_cnpj       VARCHAR2(20) NOT NULL,
    nm_fantasia   VARCHAR2(30) NOT NULL,
    t_user_pj_id  NUMBER NOT NULL
);

ALTER TABLE t_user_pj ADD CONSTRAINT t_user_pj_pk PRIMARY KEY ( t_user_pj_id );

ALTER TABLE t_bairro
    ADD CONSTRAINT t_bairro_t_cidade_fk FOREIGN KEY ( t_cidade_id_cidade )
        REFERENCES t_cidade ( id_cidade );

ALTER TABLE t_cidade
    ADD CONSTRAINT t_cidade_t_estado_fk FOREIGN KEY ( t_estado_id_estado )
        REFERENCES t_estado ( id_estado );

ALTER TABLE t_end
    ADD CONSTRAINT t_end_t_logra_fk FOREIGN KEY ( t_logra_id_logra )
        REFERENCES t_logra ( id_logra );

ALTER TABLE t_logra
    ADD CONSTRAINT t_logra_t_bairro_fk FOREIGN KEY ( t_bairro_id_bairro )
        REFERENCES t_bairro ( id_bairro );

ALTER TABLE t_promo
    ADD CONSTRAINT t_promo_t_parceiro_fk FOREIGN KEY ( t_parceiro_id_parceiro )
        REFERENCES t_parceiro ( id_parceiro );

ALTER TABLE t_servico
    ADD CONSTRAINT t_servico_t_promo_fk FOREIGN KEY ( t_promo_id_promo,
                                                      t_promo_t_parceiro_id_parceiro )
        REFERENCES t_promo ( id_promo,
                             t_parceiro_id_parceiro );

ALTER TABLE t_servico
    ADD CONSTRAINT t_servico_t_tp_serv_fk FOREIGN KEY ( t_tp_serv_id_tp_serv )
        REFERENCES t_tp_serv ( id_tp_serv );

ALTER TABLE t_servico
    ADD CONSTRAINT t_servico_t_user_fk FOREIGN KEY ( t_user_id_user )
        REFERENCES t_user ( id_user );

ALTER TABLE t_tp_resid
    ADD CONSTRAINT t_tp_resid_t_coleta_fk FOREIGN KEY ( t_coleta_id_coleta )
        REFERENCES t_coleta ( id_coleta );

ALTER TABLE t_tp_serv
    ADD CONSTRAINT t_tp_serv_t_coleta_fk FOREIGN KEY ( t_coleta_id_coleta )
        REFERENCES t_coleta ( id_coleta );

ALTER TABLE t_tp_serv
    ADD CONSTRAINT t_tp_serv_t_relatorio_fk FOREIGN KEY ( t_relatorio_id_relat )
        REFERENCES t_relatorio ( id_relat );

ALTER TABLE t_user
    ADD CONSTRAINT t_user_t_end_fk FOREIGN KEY ( t_end_id_end )
        REFERENCES t_end ( id_end );

ALTER TABLE t_user
    ADD CONSTRAINT t_user_t_user_pf_fk FOREIGN KEY ( t_user_pf_t_user_pf_id )
        REFERENCES t_user_pf ( t_user_pf_id );

ALTER TABLE t_user
    ADD CONSTRAINT t_user_t_user_pj_fk FOREIGN KEY ( t_user_pj_t_user_pj_id )
        REFERENCES t_user_pj ( t_user_pj_id );

CREATE SEQUENCE t_user_pf_t_user_pf_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER t_user_pf_t_user_pf_id_trg BEFORE
    INSERT ON t_user_pf
    FOR EACH ROW
    WHEN ( new.t_user_pf_id IS NULL )
BEGIN
    :new.t_user_pf_id := t_user_pf_t_user_pf_id_seq.nextval;
END;
/

CREATE SEQUENCE t_user_pj_t_user_pj_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER t_user_pj_t_user_pj_id_trg BEFORE
    INSERT ON t_user_pj
    FOR EACH ROW
    WHEN ( new.t_user_pj_id IS NULL )
BEGIN
    :new.t_user_pj_id := t_user_pj_t_user_pj_id_seq.nextval;
END;
/



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            15
-- CREATE INDEX                             4
-- ALTER TABLE                             29
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           2
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          2
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
