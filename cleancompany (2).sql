drop database if exists "tachoCompany";
CREATE DATABASE "tachoCompany";

   
CREATE SCHEMA "cleanCompany"
    AUTHORIZATION postgres;

 drop table if exists cliente;
CREATE TABLE "cleanCompany"."cliente" (
"idCliente" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
"nombre" varchar(150),
"descripcion" varchar(250),
"telefono" varchar(100),
"direccion" varchar(250),
"eliminado" boolean DEFAULT 'false',
PRIMARY KEY ("idCliente") 
)
WITHOUT OIDS;

 drop table if exists servicio;
CREATE TABLE "cleanCompany"."servicio" (
"idServicio" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
"nombre" varchar(150),
"descripcion" varchar(250),
"unidadCostoServicio" varchar(150),
"valorCostoServicio" int8,
"tipoUnidadMantenimiento" int8,
"cantidadTiempoMantenimiento" int8,
"eliminado" boolean DEFAULT 'false',
PRIMARY KEY ("idServicio") 
)
WITHOUT OIDS;
 drop table if exists ProgramacionServicio;
CREATE TABLE "cleanCompany"."ProgramacionServicio" (
"idServicio" int8,
"idCliente" int8,
"unidadCostoServicio" varchar(150),
"valorCostoServicio" int8,
"tipoUnidadmantenimiento" int8,
"cantidadTiempoMantenimiento" int8,
"fecha" date,
"darleSeguimiento" bool,
"eliminado" boolean DEFAULT 'false'
)
WITHOUT OIDS;
 drop table if exists tiempo;
CREATE TABLE "cleanCompany"."tiempo" (
"idTiempo" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
"dias" int8,
"nombre" varchar(150),
PRIMARY KEY ("idTiempo") 
)
WITHOUT OIDS;

ALTER TABLE "cleanCompany"."ProgramacionServicio" ADD CONSTRAINT "fk_servicio_ProgramacionServicio_1" FOREIGN KEY ("idServicio") REFERENCES "cleanCompany"."servicio" ("idServicio");
ALTER TABLE "cleanCompany"."ProgramacionServicio" ADD CONSTRAINT "fk_cliente_ProgramacionServicio_1" FOREIGN KEY ("idCliente") REFERENCES "cleanCompany"."cliente" ("idCliente");
ALTER TABLE "cleanCompany"."servicio" ADD CONSTRAINT "fk_tiempo_servicio_1" FOREIGN KEY ("tipoUnidadMantenimiento") REFERENCES "cleanCompany"."tiempo" ("idTiempo");
ALTER TABLE "cleanCompany"."ProgramacionServicio" ADD CONSTRAINT "fk_ProgramacionServicio_tiempo_1" FOREIGN KEY ("tipoUnidadmantenimiento") REFERENCES  "cleanCompany"."tiempo" ("idTiempo");

INSERT INTO "cleanCompany".tiempo(
	dias, nombre)
	VALUES ( '1', 'dia');

 INSERT INTO "cleanCompany".tiempo(
	dias, nombre)
	VALUES ( '7', 'semana');

INSERT INTO "cleanCompany".tiempo(
	dias, nombre)
	VALUES ( '30', 'mes');   