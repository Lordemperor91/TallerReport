-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.44 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bd_arlet
CREATE DATABASE IF NOT EXISTS `bd_arlet` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_arlet`;

-- Volcando estructura para tabla bd_arlet.apprentice
CREATE TABLE IF NOT EXISTS `apprentice` (
  `document` bigint(20) NOT NULL COMMENT 'número de documento',
  `full_name` varchar(100) NOT NULL COMMENT 'nombre completo',
  `email` varchar(50) DEFAULT NULL,
  `id_course` int(11) NOT NULL COMMENT 'fk ficha',
  PRIMARY KEY (`document`),
  KEY `FK_apprentice_course` (`id_course`),
  CONSTRAINT `FK_apprentice_course` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tabla aprendiz';

-- Volcando datos para la tabla bd_arlet.apprentice: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `apprentice` DISABLE KEYS */;
INSERT INTO `apprentice` (`document`, `full_name`, `email`, `id_course`) VALUES
	(111600200, 'Homero J. Simpson', 'homero@mail.com', 2305023),
	(1116000100, 'Ned Flanders', 'flanders@mail.com', 2395066);
/*!40000 ALTER TABLE `apprentice` ENABLE KEYS */;

-- Volcando estructura para tabla bd_arlet.course
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL COMMENT 'numero de ficha',
  `career` varchar(100) DEFAULT NULL COMMENT 'programa de formacion',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tabla de ficha';

-- Volcando datos para la tabla bd_arlet.course: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `career`) VALUES
	(1899027, 'Sistemas'),
	(2305023, 'Seguridad y salud en el trabajo'),
	(2395066, 'ADSI');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Volcando estructura para tabla bd_arlet.late_arrival
CREATE TABLE IF NOT EXISTS `late_arrival` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_arrival` date NOT NULL,
  `observations` varchar(200) DEFAULT NULL,
  `document_apprentice` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_late_arrival_apprentice` (`document_apprentice`),
  CONSTRAINT `FK_late_arrival_apprentice` FOREIGN KEY (`document_apprentice`) REFERENCES `apprentice` (`document`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='tabla llegadas tarde';

-- Volcando datos para la tabla bd_arlet.late_arrival: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `late_arrival` DISABLE KEYS */;
INSERT INTO `late_arrival` (`id`, `date_arrival`, `observations`, `document_apprentice`) VALUES
	(1, '2022-08-29', 'Se me pinchó la moto', 1116000100),
	(2, '2022-09-12', NULL, 111600200),
	(3, '2022-09-15', 'Cita médica', 1116000100),
	(4, '2022-09-16', 'Me cogió la tarde', 1116000100);
/*!40000 ALTER TABLE `late_arrival` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
