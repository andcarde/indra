CREATE SCHEMA `clinica` ;
Use clinica;

CREATE TABLE obraso (
  `codoso` INT NOT NULL, -- ID de la obra social
  `nomoso` VARCHAR(45) NULL, -- Nombre de la obra social
  `des_rem` INT NULL, -- Descuento en remedios
  `des_int` INT NULL, -- Descuento en internación
  PRIMARY KEY (`codoso`)
);

CREATE TABLE precios (
  `claseh` VARCHAR(1) NOT NULL, -- Tratamiento
  `descri` VARCHAR(45) NULL, -- Descripción
  `precio` DOUBLE NULL, -- Precio
  PRIMARY KEY (`claseh`)
); 

CREATE TABLE pacientes (
  `codpac` INT NOT NULL, -- ID de paciente
  `codoso` INT NOT NULL, -- ID de la obra social
  `apellido` VARCHAR(45) NULL, -- Apellido
  `nombre` VARCHAR(45) NULL, -- Nombre
  `localidad` VARCHAR(45) NULL, -- Localidad
  `telefono` VARCHAR(45) NULL, -- Teléfono
  `gruporh` VARCHAR(2) NULL, -- Grupo
  `fecnac` DATE NULL, -- Fecha de nacimiento
  `sexo` VARCHAR(1) NULL, -- Sexo
  `internado` BOOLEAN NULL, -- ¿Está internado?
  PRIMARY KEY (`codpac`)
);

CREATE TABLE internacion (
  `numint` INT NOT NULL, -- ID de internamiento
  `codpac` INT NOT NULL, -- ID de paciente
  `fecint` DATE NULL, -- Fecha de inicio de internamiento
  `habitacion` INT NULL, -- Habitación
  `claseh` VARCHAR(1) NOT NULL, -- Tratamiento
  `est_alta` DATE NULL, -- Fecha de alta estimada
  `fecalt` DATE NULL, -- Fecha de alta
  `remedios` DOUBLE NOT NULL, -- Factura de los remedios consumidos durante la internación
  PRIMARY KEY (`numint`)
);
