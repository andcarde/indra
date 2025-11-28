CREATE SCHEMA `clinica` ;
Use clinica;
-- creacion de las tablas
CREATE TABLE obraso (
  `codoso` INT NOT NULL,
  `nomoso` VARCHAR(45) NULL,
  `des_rem` INT NULL,
  `des_int` INT NULL,
  PRIMARY KEY (`codoso`));

CREATE TABLE precios (
  `claseh` VARCHAR(1) NOT NULL,
  `descri` VARCHAR(45) NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`claseh`));

CREATE TABLE pacientes (
  `codpac` INT NOT NULL,
  `codoso` INT NOT NULL,
  `apellido` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `gruporh` VARCHAR(2) NULL,
  `fecnac` DATE NULL,
  `sexo` VARCHAR(1) NULL,
  `internado` BOOLEAN NULL,
  PRIMARY KEY (`codpac`));

CREATE TABLE internacion (
  `numint` INT NOT NULL,
  `codpac` INT NOT NULL,
  `fecint` DATE NULL,
  `habitacion` INT NULL,
  `claseh` VARCHAR(1) NOT NULL,
  `est_alta` DATE NULL,
  `fecalt` DATE NULL,
  `remedios` DOUBLE NOT NULL,
  PRIMARY KEY (`numint`));