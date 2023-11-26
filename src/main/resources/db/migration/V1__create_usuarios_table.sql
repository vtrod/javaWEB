-- Table: public.usuario

-- DROP TABLE IF EXISTS public.usuario;

CREATE TABLE IF NOT EXISTS public.usuario
(
    id bigint NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    nome character varying(255) COLLATE pg_catalog."default",
    linguagem character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
    )


-- Trigger: reiniciar_sequencia_trigger

-- DROP TRIGGER IF EXISTS reiniciar_sequencia_trigger ON public.usuario;
CREATE SEQUENCE IF NOT EXISTS public.usuario_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY usuario.id;

CREATE OR REPLACE TRIGGER reiniciar_sequencia_trigger
    AFTER DELETE
ON public.usuario
    FOR EACH ROW
    EXECUTE FUNCTION public.reiniciar_sequencia();

CREATE TABLE IF NOT EXISTS public.funcionario
(
    id_func bigint NOT NULL,
    nome_func character varying(255) COLLATE pg_catalog."default",
    linguagem_func character varying(255) COLLATE pg_catalog."default",
    usu_id bigint NOT NULL,
    CONSTRAINT funcionario_pkey PRIMARY KEY (id_func),
    CONSTRAINT usufuncid FOREIGN KEY (id_func)
    REFERENCES public.usuario (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID
    )
CREATE TABLE IF NOT EXISTS public.vaga
(
    id bigint NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT vaga_pkey PRIMARY KEY (id_vaga)
    )
