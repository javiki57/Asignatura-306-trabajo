CREATE TABLE ALUMNO (ID INTEGER NOT NULL, CODIGO_POSTAL_NOTIFICACION VARCHAR(255), DNI VARCHAR(255) NOT NULL UNIQUE, DIRECCION_NOTIFICACION VARCHAR(255), EMAIL_INSTITUCIONAL VARCHAR(255) NOT NULL, EMAIL_PERSONAL VARCHAR(255), FECHA_NACIMIENTO VARCHAR(255), MOVIL INTEGER, NOMBRE_COMPLETO VARCHAR(255) NOT NULL, TELEFONO INTEGER, PRIMARY KEY (ID))
CREATE TABLE ASIGNATURA (REFERENCIA INTEGER NOT NULL, CARACTER VARCHAR(255), CODIGO INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, CURSO INTEGER, DEPARTAMENTO VARCHAR(255), DURACION INTEGER, IDIOMA VARCHAR(255), NOMBRE VARCHAR(255) NOT NULL, OFERTADA TINYINT(1) default 0 NOT NULL, UNIDAD_TEMPORAL INTEGER, MENCION VARCHAR(255), PLAZAS INTEGER, TITULACION_CODIGO INTEGER, PRIMARY KEY (REFERENCIA))
CREATE TABLE TITULACION (CODIGO INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, NOMBRE VARCHAR(255) NOT NULL, PRIMARY KEY (CODIGO))
CREATE TABLE GRUPO (ID BIGINT NOT NULL, ASIGNAR VARCHAR(255), CURSO VARCHAR(255) NOT NULL UNIQUE, INGLES TINYINT(1) default 0 NOT NULL, LETRA CHAR(1) NOT NULL UNIQUE, PLAZAS INTEGER, TURNO_MAÑANA_TARDE VARCHAR(255) NOT NULL, VISIBLE TINYINT(1) default 0, GRUP0_ID BIGINT, TITULACION_CODIGO INTEGER, PRIMARY KEY (ID))
CREATE TABLE EXPEDIENTE (NUM_EXPEDIENTE INTEGER NOT NULL, ACTIVA TINYINT(1) default 0, CREDITOS_CF INTEGER, CREDITOS_FORMACION_BASICA INTEGER, CREDITOS_OPTATIVOS INTEGER, CREDITOS_PRACTICAS_EXTERNAS INTEGER, CREDITOS_SUPERADOS INTEGER, CREDITOS_TFG INTEGER, NOTA_MEDIA_PROVISIONAL INTEGER, ALUMNO_ID INTEGER, TITULACION_CODIGO INTEGER, PRIMARY KEY (NUM_EXPEDIENTE))
CREATE TABLE MATRICULA (CURSO_ACADEMICO INTEGER NOT NULL, ESTADO VARCHAR(255) NOT NULL, FECHA_DE_MATRICULA DATE NOT NULL, NUEVO_INGRESO TINYINT(1) default 0, NUM_ARCHIVO INTEGER, TURNO_PREFERENTE VARCHAR(255), EXPEDIENTE_NUM_EXPEDIENTE INTEGER NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE))
CREATE TABLE CLASE (HORA_INICIO DOUBLE NOT NULL, DIA VARCHAR(255) NOT NULL, HORA_FIN DOUBLE, ASIGNATURA_REFERENCIA INTEGER, GRUPO_ID BIGINT NOT NULL, PRIMARY KEY (HORA_INICIO, DIA, GRUPO_ID))
CREATE TABLE GRUPO_POR_ASIGNATURA (CURSO_ACADEMICO INTEGER NOT NULL, OFERTA INTEGER, ASIGNATURAS_REFERENCIA INTEGER NOT NULL, GRUPOS_ID BIGINT NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, ASIGNATURAS_REFERENCIA, GRUPOS_ID))
CREATE TABLE CENTRO (ID INTEGER NOT NULL, DIRECCION VARCHAR(255) NOT NULL, NOMBRE VARCHAR(255) NOT NULL UNIQUE, TLF_CONSERJERIA INTEGER, PRIMARY KEY (ID))
CREATE TABLE ENCUESTA (FECHA_DE_ENVIO DATE NOT NULL, EXPEDIENTE_NUM_EXPEDIENTE INTEGER, PRIMARY KEY (FECHA_DE_ENVIO))
CREATE TABLE ASIGNATURA_MATRICULA (ASIGNATURA_REFERENCIA INTEGER NOT NULL, GRUPO_ID BIGINT, CURSO_ACADEMICO INTEGER NOT NULL, EXPEDIENTE_NUM_EXPEDIENTE INTEGER NOT NULL, PRIMARY KEY (ASIGNATURA_REFERENCIA, CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE))
CREATE TABLE TITULACION_ASIGNATURA (Titulacion_CODIGO INTEGER NOT NULL, asignaturas_REFERENCIA INTEGER NOT NULL, PRIMARY KEY (Titulacion_CODIGO, asignaturas_REFERENCIA))
CREATE TABLE CENTRO_TITULACION (titulacion_CODIGO INTEGER NOT NULL, centro_ID INTEGER NOT NULL, PRIMARY KEY (titulacion_CODIGO, centro_ID))
CREATE TABLE GRUPO_CLASE (Grupo_ID BIGINT NOT NULL, HORA_INICIO DOUBLE NOT NULL, DIA VARCHAR(255) NOT NULL, PRIMARY KEY (Grupo_ID, HORA_INICIO, DIA))
CREATE TABLE GRUPO_GRUPO_POR_ASIGNATURA (Grupo_ID BIGINT NOT NULL, CURSO_ACADEMICO INTEGER NOT NULL, GRUPOS_ID BIGINT NOT NULL, ASIGNATURAS_REFERENCIA INTEGER NOT NULL, PRIMARY KEY (Grupo_ID, CURSO_ACADEMICO, GRUPOS_ID, ASIGNATURAS_REFERENCIA))
CREATE TABLE Matricula_LISTADO_ASIGNATURAS (CURSO_ACADEMICO INTEGER, EXPEDIENTE_NUM_EXPEDIENTE INTEGER, LISTADO_ASIGNATURAS VARCHAR(255))
CREATE TABLE ENCUESTA_GRUPO_POR_ASIGNATURA (CURSO_ACADEMICO INTEGER NOT NULL, GRUPOS_ID BIGINT NOT NULL, ASIGNATURAS_REFERENCIA INTEGER NOT NULL, encuestas_FECHA_DE_ENVIO DATE NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, GRUPOS_ID, ASIGNATURAS_REFERENCIA, encuestas_FECHA_DE_ENVIO))
ALTER TABLE ASIGNATURA ADD CONSTRAINT FK_ASIGNATURA_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_GRUP0_ID FOREIGN KEY (GRUP0_ID) REFERENCES GRUPO (ID)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_EXPEDIENTE_TITULACION_CODIGO FOREIGN KEY (TITULACION_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_EXPEDIENTE_ALUMNO_ID FOREIGN KEY (ALUMNO_ID) REFERENCES ALUMNO (ID)
ALTER TABLE MATRICULA ADD CONSTRAINT FK_MATRICULA_EXPEDIENTE_NUM_EXPEDIENTE FOREIGN KEY (EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES EXPEDIENTE (NUM_EXPEDIENTE)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE GRUPO_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPO_POR_ASIGNATURA_ASIGNATURAS_REFERENCIA FOREIGN KEY (ASIGNATURAS_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE GRUPO_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPO_POR_ASIGNATURA_GRUPOS_ID FOREIGN KEY (GRUPOS_ID) REFERENCES GRUPO (ID)
ALTER TABLE ENCUESTA ADD CONSTRAINT FK_ENCUESTA_EXPEDIENTE_NUM_EXPEDIENTE FOREIGN KEY (EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES EXPEDIENTE (NUM_EXPEDIENTE)
ALTER TABLE ASIGNATURA_MATRICULA ADD CONSTRAINT FK_ASIGNATURA_MATRICULA_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE ASIGNATURA_MATRICULA ADD CONSTRAINT FK_ASIGNATURA_MATRICULA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES MATRICULA (CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE)
ALTER TABLE ASIGNATURA_MATRICULA ADD CONSTRAINT FK_ASIGNATURA_MATRICULA_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE TITULACION_ASIGNATURA ADD CONSTRAINT FK_TITULACION_ASIGNATURA_asignaturas_REFERENCIA FOREIGN KEY (asignaturas_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE TITULACION_ASIGNATURA ADD CONSTRAINT FK_TITULACION_ASIGNATURA_Titulacion_CODIGO FOREIGN KEY (Titulacion_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE CENTRO_TITULACION ADD CONSTRAINT FK_CENTRO_TITULACION_titulacion_CODIGO FOREIGN KEY (titulacion_CODIGO) REFERENCES TITULACION (CODIGO)
ALTER TABLE CENTRO_TITULACION ADD CONSTRAINT FK_CENTRO_TITULACION_centro_ID FOREIGN KEY (centro_ID) REFERENCES CENTRO (ID)
ALTER TABLE GRUPO_CLASE ADD CONSTRAINT FK_GRUPO_CLASE_Grupo_ID FOREIGN KEY (Grupo_ID) REFERENCES GRUPO (ID)
ALTER TABLE GRUPO_CLASE ADD CONSTRAINT FK_GRUPO_CLASE_HORA_INICIO FOREIGN KEY (HORA_INICIO, DIA, GRUPO_ID) REFERENCES CLASE (HORA_INICIO, DIA, GRUPO_ID)
ALTER TABLE GRUPO_GRUPO_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPO_GRUPO_POR_ASIGNATURA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, ASIGNATURAS_REFERENCIA, GRUPOS_ID) REFERENCES GRUPO_POR_ASIGNATURA (CURSO_ACADEMICO, ASIGNATURAS_REFERENCIA, GRUPOS_ID)
ALTER TABLE GRUPO_GRUPO_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPO_GRUPO_POR_ASIGNATURA_Grupo_ID FOREIGN KEY (Grupo_ID) REFERENCES GRUPO (ID)
ALTER TABLE Matricula_LISTADO_ASIGNATURAS ADD CONSTRAINT FK_Matricula_LISTADO_ASIGNATURAS_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES MATRICULA (CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE)
ALTER TABLE ENCUESTA_GRUPO_POR_ASIGNATURA ADD CONSTRAINT FK_ENCUESTA_GRUPO_POR_ASIGNATURA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, ASIGNATURAS_REFERENCIA, GRUPOS_ID) REFERENCES GRUPO_POR_ASIGNATURA (CURSO_ACADEMICO, ASIGNATURAS_REFERENCIA, GRUPOS_ID)
ALTER TABLE ENCUESTA_GRUPO_POR_ASIGNATURA ADD CONSTRAINT ENCUESTAGRUPOPORASIGNATURAencuestas_FECHA_DE_ENVIO FOREIGN KEY (encuestas_FECHA_DE_ENVIO) REFERENCES ENCUESTA (FECHA_DE_ENVIO)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
