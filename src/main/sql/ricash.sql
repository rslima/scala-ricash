--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: ricash; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA ricash;


ALTER SCHEMA ricash OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = ricash, pg_catalog;

--
-- Name: seq_user; Type: SEQUENCE; Schema: ricash; Owner: postgres
--

CREATE SEQUENCE seq_user
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE seq_user OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tbl_user; Type: TABLE; Schema: ricash; Owner: postgres; Tablespace: 
--

CREATE TABLE tbl_user (
    id integer DEFAULT nextval('seq_user'::regclass) NOT NULL,
    name character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL
);


ALTER TABLE tbl_user OWNER TO postgres;

--
-- Name: pk_user; Type: CONSTRAINT; Schema: ricash; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbl_user
    ADD CONSTRAINT pk_user PRIMARY KEY (id);


--
-- Name: unq_user_email; Type: INDEX; Schema: ricash; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX unq_user_email ON tbl_user USING btree (email);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

