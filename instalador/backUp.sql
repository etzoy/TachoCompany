--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-01-17 09:55:36

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 16394)
-- Name: cleanCompany; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "cleanCompany";


ALTER SCHEMA "cleanCompany" OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 16411)
-- Name: ProgramacionServicio; Type: TABLE; Schema: cleanCompany; Owner: postgres
--

CREATE TABLE "cleanCompany"."ProgramacionServicio" (
    "idServicio" bigint,
    "idCliente" bigint,
    "unidadCostoServicio" character varying(150),
    "valorCostoServicio" bigint,
    "tipoUnidadmantenimiento" bigint,
    "cantidadTiempoMantenimiento" bigint,
    fecha date,
    "darleSeguimiento" boolean,
    eliminado bigint DEFAULT 0 NOT NULL,
    "horaInicio" time without time zone,
    "horaFin" time without time zone
);


ALTER TABLE "cleanCompany"."ProgramacionServicio" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16395)
-- Name: cliente; Type: TABLE; Schema: cleanCompany; Owner: postgres
--

CREATE TABLE "cleanCompany".cliente (
    "idCliente" bigint NOT NULL,
    nombre character varying(150),
    descripcion character varying(250),
    telefono character varying(100),
    direccion character varying(250),
    eliminado bigint DEFAULT 0
);


ALTER TABLE "cleanCompany".cliente OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16439)
-- Name: cliente_idCliente_seq; Type: SEQUENCE; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE "cleanCompany".cliente ALTER COLUMN "idCliente" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME "cleanCompany"."cliente_idCliente_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1
    CYCLE
);


--
-- TOC entry 204 (class 1259 OID 16403)
-- Name: servicio; Type: TABLE; Schema: cleanCompany; Owner: postgres
--

CREATE TABLE "cleanCompany".servicio (
    "idServicio" bigint NOT NULL,
    nombre character varying(150),
    descripcion character varying(250),
    "unidadCostoServicio" character varying(150),
    "valorCostoServicio" bigint,
    "tipoUnidadMantenimiento" bigint,
    "cantidadTiempoMantenimiento" bigint,
    eliminado bigint DEFAULT 0
);


ALTER TABLE "cleanCompany".servicio OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16442)
-- Name: servicio_idServicio_seq; Type: SEQUENCE; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE "cleanCompany".servicio ALTER COLUMN "idServicio" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME "cleanCompany"."servicio_idServicio_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1
);


--
-- TOC entry 206 (class 1259 OID 16414)
-- Name: tiempo; Type: TABLE; Schema: cleanCompany; Owner: postgres
--

CREATE TABLE "cleanCompany".tiempo (
    "idTiempo" bigint NOT NULL,
    dias bigint,
    nombre character varying(150)
);


ALTER TABLE "cleanCompany".tiempo OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16444)
-- Name: tiempo_idTiempo_seq; Type: SEQUENCE; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE "cleanCompany".tiempo ALTER COLUMN "idTiempo" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME "cleanCompany"."tiempo_idTiempo_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 23423425222
    CACHE 1
);


--
-- TOC entry 2847 (class 0 OID 16411)
-- Dependencies: 205
-- Data for Name: ProgramacionServicio; Type: TABLE DATA; Schema: cleanCompany; Owner: postgres
--


--
-- TOC entry 2845 (class 0 OID 16395)
-- Dependencies: 203
-- Data for Name: cliente; Type: TABLE DATA; Schema: cleanCompany; Owner: postgres
--



--
-- TOC entry 2846 (class 0 OID 16403)
-- Dependencies: 204
-- Data for Name: servicio; Type: TABLE DATA; Schema: cleanCompany; Owner: postgres
--




--
-- TOC entry 2848 (class 0 OID 16414)
-- Dependencies: 206
-- Data for Name: tiempo; Type: TABLE DATA; Schema: cleanCompany; Owner: postgres
--

COPY "cleanCompany".tiempo ("idTiempo", dias, nombre) FROM stdin;
1	1	dia
2	7	semana
3	30	mes
\.


--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 207
-- Name: cliente_idCliente_seq; Type: SEQUENCE SET; Schema: cleanCompany; Owner: postgres
--

SELECT pg_catalog.setval('"cleanCompany"."cliente_idCliente_seq"', 50, true);


--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 208
-- Name: servicio_idServicio_seq; Type: SEQUENCE SET; Schema: cleanCompany; Owner: postgres
--

SELECT pg_catalog.setval('"cleanCompany"."servicio_idServicio_seq"', 12, true);


--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 209
-- Name: tiempo_idTiempo_seq; Type: SEQUENCE SET; Schema: cleanCompany; Owner: postgres
--

SELECT pg_catalog.setval('"cleanCompany"."tiempo_idTiempo_seq"', 3, true);


--
-- TOC entry 2710 (class 2606 OID 16402)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE ONLY "cleanCompany".cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY ("idCliente");


--
-- TOC entry 2712 (class 2606 OID 16410)
-- Name: servicio servicio_pkey; Type: CONSTRAINT; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE ONLY "cleanCompany".servicio
    ADD CONSTRAINT servicio_pkey PRIMARY KEY ("idServicio");


--
-- TOC entry 2714 (class 2606 OID 16418)
-- Name: tiempo tiempo_pkey; Type: CONSTRAINT; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE ONLY "cleanCompany".tiempo
    ADD CONSTRAINT tiempo_pkey PRIMARY KEY ("idTiempo");


--
-- TOC entry 2718 (class 2606 OID 16434)
-- Name: ProgramacionServicio fk_ProgramacionServicio_tiempo_1; Type: FK CONSTRAINT; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE ONLY "cleanCompany"."ProgramacionServicio"
    ADD CONSTRAINT "fk_ProgramacionServicio_tiempo_1" FOREIGN KEY ("tipoUnidadmantenimiento") REFERENCES "cleanCompany".tiempo("idTiempo");


--
-- TOC entry 2717 (class 2606 OID 16424)
-- Name: ProgramacionServicio fk_cliente_ProgramacionServicio_1; Type: FK CONSTRAINT; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE ONLY "cleanCompany"."ProgramacionServicio"
    ADD CONSTRAINT "fk_cliente_ProgramacionServicio_1" FOREIGN KEY ("idCliente") REFERENCES "cleanCompany".cliente("idCliente");


--
-- TOC entry 2716 (class 2606 OID 16419)
-- Name: ProgramacionServicio fk_servicio_ProgramacionServicio_1; Type: FK CONSTRAINT; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE ONLY "cleanCompany"."ProgramacionServicio"
    ADD CONSTRAINT "fk_servicio_ProgramacionServicio_1" FOREIGN KEY ("idServicio") REFERENCES "cleanCompany".servicio("idServicio");


--
-- TOC entry 2715 (class 2606 OID 16429)
-- Name: servicio fk_tiempo_servicio_1; Type: FK CONSTRAINT; Schema: cleanCompany; Owner: postgres
--

ALTER TABLE ONLY "cleanCompany".servicio
    ADD CONSTRAINT fk_tiempo_servicio_1 FOREIGN KEY ("tipoUnidadMantenimiento") REFERENCES "cleanCompany".tiempo("idTiempo");


-- Completed on 2020-01-17 09:55:40

--
-- PostgreSQL database dump complete
--

