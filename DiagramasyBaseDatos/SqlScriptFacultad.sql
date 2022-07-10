-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema facultad
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema facultad
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `facultad` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `facultad` ;

-- -----------------------------------------------------
-- Table `facultad`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`administrador` (
  `idAdministrador` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idAdministrador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `facultad`.`cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`cuenta` (
  `idCuenta` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCuenta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `facultad`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `documento` VARCHAR(45) NOT NULL,
  `administrador_idAdministrador` INT NOT NULL,
  `cuenta_idCuenta` INT NOT NULL,
  PRIMARY KEY (`idPersona`, `administrador_idAdministrador`, `cuenta_idCuenta`),
  INDEX `fk_persona_administrador1_idx` (`administrador_idAdministrador` ASC) VISIBLE,
  INDEX `fk_persona_cuenta1_idx` (`cuenta_idCuenta` ASC) VISIBLE,
  CONSTRAINT `fk_persona_administrador1`
    FOREIGN KEY (`administrador_idAdministrador`)
    REFERENCES `facultad`.`administrador` (`idAdministrador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_cuenta1`
    FOREIGN KEY (`cuenta_idCuenta`)
    REFERENCES `facultad`.`cuenta` (`idCuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `facultad`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`alumno` (
  `idAlumno` INT NOT NULL AUTO_INCREMENT,
  `persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`idAlumno`, `persona_idPersona`),
  INDEX `fk_alumno_persona_idx` (`persona_idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_alumno_persona`
    FOREIGN KEY (`persona_idPersona`)
    REFERENCES `facultad`.`persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `facultad`.`carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`carrera` (
  `idCarrera` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idCarrera`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `facultad`.`estadocurricular`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`estadocurricular` (
  `idEstadoCurricular` INT NOT NULL,
  `alumno_idAlumno` INT NOT NULL,
  `alumno_persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`idEstadoCurricular`, `alumno_idAlumno`, `alumno_persona_idPersona`),
  INDEX `fk_estadocurricular_alumno1_idx` (`alumno_idAlumno` ASC, `alumno_persona_idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_estadocurricular_alumno1`
    FOREIGN KEY (`alumno_idAlumno` , `alumno_persona_idPersona`)
    REFERENCES `facultad`.`alumno` (`idAlumno` , `persona_idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `facultad`.`inscripcioncarrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`inscripcioncarrera` (
  `idInscripcionCarrera` INT NOT NULL AUTO_INCREMENT,
  `carrera_idCarrera` INT NOT NULL,
  `alumno_idAlumno` INT NOT NULL,
  `alumno_persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`idInscripcionCarrera`, `carrera_idCarrera`, `alumno_idAlumno`, `alumno_persona_idPersona`),
  INDEX `fk_inscripcioncarrera_carrera1_idx` (`carrera_idCarrera` ASC) VISIBLE,
  INDEX `fk_inscripcioncarrera_alumno1_idx` (`alumno_idAlumno` ASC, `alumno_persona_idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_inscripcioncarrera_carrera1`
    FOREIGN KEY (`carrera_idCarrera`)
    REFERENCES `facultad`.`carrera` (`idCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripcioncarrera_alumno1`
    FOREIGN KEY (`alumno_idAlumno` , `alumno_persona_idPersona`)
    REFERENCES `facultad`.`alumno` (`idAlumno` , `persona_idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `facultad`.`materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`materia` (
  `idMateria` INT NOT NULL AUTO_INCREMENT,
  `nota` DOUBLE NULL DEFAULT NULL,
  `carrera_idCarrera` INT NOT NULL,
  `estadocurricular_idEstadoCurricular` INT NOT NULL,
  `estadocurricular_alumno_idAlumno` INT NOT NULL,
  `estadocurricular_alumno_persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`idMateria`, `carrera_idCarrera`, `estadocurricular_idEstadoCurricular`, `estadocurricular_alumno_idAlumno`, `estadocurricular_alumno_persona_idPersona`),
  INDEX `fk_materia_carrera1_idx` (`carrera_idCarrera` ASC) VISIBLE,
  INDEX `fk_materia_estadocurricular1_idx` (`estadocurricular_idEstadoCurricular` ASC, `estadocurricular_alumno_idAlumno` ASC, `estadocurricular_alumno_persona_idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_materia_carrera1`
    FOREIGN KEY (`carrera_idCarrera`)
    REFERENCES `facultad`.`carrera` (`idCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_materia_estadocurricular1`
    FOREIGN KEY (`estadocurricular_idEstadoCurricular` , `estadocurricular_alumno_idAlumno` , `estadocurricular_alumno_persona_idPersona`)
    REFERENCES `facultad`.`estadocurricular` (`idEstadoCurricular` , `alumno_idAlumno` , `alumno_persona_idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `facultad`.`inscripcionmateria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultad`.`inscripcionmateria` (
  `idInscripcionMateria` INT NOT NULL,
  `alumno_idAlumno` INT NOT NULL,
  `alumno_persona_idPersona` INT NOT NULL,
  `materia_idMateria` INT NOT NULL,
  PRIMARY KEY (`idInscripcionMateria`, `alumno_idAlumno`, `alumno_persona_idPersona`, `materia_idMateria`),
  INDEX `fk_inscripcionmateria_alumno1_idx` (`alumno_idAlumno` ASC, `alumno_persona_idPersona` ASC) VISIBLE,
  INDEX `fk_inscripcionmateria_materia1_idx` (`materia_idMateria` ASC) VISIBLE,
  CONSTRAINT `fk_inscripcionmateria_alumno1`
    FOREIGN KEY (`alumno_idAlumno` , `alumno_persona_idPersona`)
    REFERENCES `facultad`.`alumno` (`idAlumno` , `persona_idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripcionmateria_materia1`
    FOREIGN KEY (`materia_idMateria`)
    REFERENCES `facultad`.`materia` (`idMateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
