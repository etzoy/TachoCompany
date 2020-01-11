
 drop table if exists cliente;
CREATE TABLE "cleanCompany"."cliente" (
"idCliente" int8 NOT NULL,
"nombre" varchar(150),
"descripcion" varchar(250),
"telefono" varchar(100),
"direccion" varchar(250),
"eliminado" int8 DEFAULT '0',
PRIMARY KEY ("idCliente") 
)
WITHOUT OIDS;

 drop table if exists servicio;
CREATE TABLE "cleanCompany"."servicio" (
"idServicio" int8 NOT NULL,
"nombre" varchar(150),
"descripcion" varchar(250),
"unidadCostoServicio" varchar(150),
"valorCostoServicio" int8,
"tipoUnidadMantenimiento" int8,
"cantidadTiempoMantenimiento" int8,
"eliminado" int8 DEFAULT '0',
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
"eliminado" int8 DEFAULT '0'
)
WITHOUT OIDS;
 drop table if exists tiempo;
CREATE TABLE "cleanCompany"."tiempo" (
"idTiempo" int8 NOT NULL,
"dias" int8,
"nombre" varchar(150),
PRIMARY KEY ("idTiempo") 
)
WITHOUT OIDS;

ALTER TABLE "cleanCompany"."ProgramacionServicio" ADD CONSTRAINT "fk_servicio_ProgramacionServicio_1" FOREIGN KEY ("idServicio") REFERENCES "cleanCompany"."servicio" ("idServicio");
ALTER TABLE "cleanCompany"."ProgramacionServicio" ADD CONSTRAINT "fk_cliente_ProgramacionServicio_1" FOREIGN KEY ("idCliente") REFERENCES "cleanCompany"."cliente" ("idCliente");
ALTER TABLE "cleanCompany"."servicio" ADD CONSTRAINT "fk_tiempo_servicio_1" FOREIGN KEY ("tipoUnidadMantenimiento") REFERENCES "cleanCompany"."tiempo" ("idTiempo");
ALTER TABLE "cleanCompany"."ProgramacionServicio" ADD CONSTRAINT "fk_ProgramacionServicio_tiempo_1" FOREIGN KEY ("tipoUnidadmantenimiento") REFERENCES  "cleanCompany"."tiempo" ("idTiempo");

