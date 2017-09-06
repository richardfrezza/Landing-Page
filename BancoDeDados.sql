-- Database: Contatos

-- DROP DATABASE "Contatos";

CREATE DATABASE "Contatos"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;



-- Table: public.contatos

-- DROP TABLE public.contatos;

CREATE TABLE public.contatos
(
    nome character varying(1000) COLLATE "default".pg_catalog,
    email character varying(1000) COLLATE "default".pg_catalog,
    telefone character varying(500) COLLATE "default".pg_catalog,
    mensagem character varying(1000) COLLATE "default".pg_catalog
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.contatos
    OWNER to postgres;