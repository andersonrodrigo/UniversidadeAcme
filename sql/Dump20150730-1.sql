CREATE DATABASE  IF NOT EXISTS `universidadeacme` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `universidadeacme`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: universidadeacme
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `perfil_usuario`
--

DROP TABLE IF EXISTS `perfil_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil_usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grupo` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `perfil_id` bigint(20) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qeu1p91wby2i80hgu7a9l6yct` (`perfil_id`),
  KEY `FK_sj8jt98cqvq69dhpap1hcv7wq` (`usuario_id`),
  CONSTRAINT `FK_sj8jt98cqvq69dhpap1hcv7wq` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK_qeu1p91wby2i80hgu7a9l6yct` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil_usuario`
--

LOCK TABLES `perfil_usuario` WRITE;
/*!40000 ALTER TABLE `perfil_usuario` DISABLE KEYS */;
INSERT INTO `perfil_usuario` VALUES (1,'Atendente','ands',3,1),(2,'Coordenador','admin',2,1),(3,'Aluno','anderson',1,5),(7,'Aluno','fabricio',1,6),(8,'Aluno','lucas',1,7),(9,'Aluno','rafael',1,8),(10,'Coordenador','tadeu',2,4),(11,'Atendente','atendente',3,3);
/*!40000 ALTER TABLE `perfil_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (1,'Arquitetura de Sistemas WEB'),(2,'Desenvolvimento de Software Ageis'),(3,'Analise de projetos I'),(4,'Analise de Projetos II');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `valorAtividade` decimal(19,2) DEFAULT NULL,
  `valorObtido` decimal(19,2) DEFAULT NULL,
  `alunoDisciplinaTurma_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pu28iokw9v8o7rbapct7scbm9` (`alunoDisciplinaTurma_id`),
  CONSTRAINT `FK_pu28iokw9v8o7rbapct7scbm9` FOREIGN KEY (`alunoDisciplinaTurma_id`) REFERENCES `alunodisciplinaturma` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES (1,'2015-08-25',100.00,99.00,1),(2,'2015-08-25',100.00,80.00,2),(3,'2015-08-25',100.00,70.00,3),(4,'2015-08-25',100.00,70.00,4),(5,'2015-08-17',50.00,30.00,1),(6,'2015-08-17',20.00,20.00,5);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `periodo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gho49v5t6gwo1sn2pa05tew0q` (`periodo_id`),
  CONSTRAINT `FK_gho49v5t6gwo1sn2pa05tew0q` FOREIGN KEY (`periodo_id`) REFERENCES `periodo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'Turma I  2015',1),(2,'Turma II 2015',2);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `aluno_id` bigint(20) DEFAULT NULL,
  `coordenador_id` bigint(20) DEFAULT NULL,
  `perfil_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ic4rgu07heh209uydwutk30ko` (`aluno_id`),
  KEY `FK_ijow8hk89xh4l43jdwcynx2ls` (`coordenador_id`),
  KEY `FK_3bbosrum107g504se9foapfkn` (`perfil_id`),
  CONSTRAINT `FK_3bbosrum107g504se9foapfkn` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`),
  CONSTRAINT `FK_ic4rgu07heh209uydwutk30ko` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`),
  CONSTRAINT `FK_ijow8hk89xh4l43jdwcynx2ls` FOREIGN KEY (`coordenador_id`) REFERENCES `coordenador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ands','Anderson','356a192b7913b04c54574d18c28d46e6395428ab	',NULL,NULL,4),(2,'admin','Administrador','356a192b7913b04c54574d18c28d46e6395428ab	',NULL,NULL,4),(3,'atendente','Atendente 1','356a192b7913b04c54574d18c28d46e6395428ab	',NULL,NULL,3),(4,'tadeu','Tadeu Coordenador','356a192b7913b04c54574d18c28d46e6395428ab	',NULL,1,NULL),(5,'anderson','Anderson','356a192b7913b04c54574d18c28d46e6395428ab	',1,NULL,NULL),(6,'fabricio','Fabricio','356a192b7913b04c54574d18c28d46e6395428ab	',2,NULL,NULL),(7,'lucas','Lucas','356a192b7913b04c54574d18c28d46e6395428ab	',3,NULL,NULL),(8,'rafael','Rafael','356a192b7913b04c54574d18c28d46e6395428ab	',4,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `coordenador_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pa19bna93huihor0jox21mewk` (`coordenador_id`),
  CONSTRAINT `FK_pa19bna93huihor0jox21mewk` FOREIGN KEY (`coordenador_id`) REFERENCES `coordenador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Arquitetura de Sistemas Distribuidos',1),(2,'Banco de Dados ',2);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplinaturma`
--

DROP TABLE IF EXISTS `disciplinaturma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplinaturma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `curso_id` bigint(20) DEFAULT NULL,
  `disciplina_id` bigint(20) DEFAULT NULL,
  `turma_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7r0ihvq9swsbdlcvjqmobhjc7` (`curso_id`),
  KEY `FK_otm351rtpxbo8qj8wec08ssnf` (`disciplina_id`),
  KEY `FK_40gmsk3nt4jltefi2h7asy237` (`turma_id`),
  CONSTRAINT `FK_40gmsk3nt4jltefi2h7asy237` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`),
  CONSTRAINT `FK_7r0ihvq9swsbdlcvjqmobhjc7` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`),
  CONSTRAINT `FK_otm351rtpxbo8qj8wec08ssnf` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplina` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplinaturma`
--

LOCK TABLES `disciplinaturma` WRITE;
/*!40000 ALTER TABLE `disciplinaturma` DISABLE KEYS */;
INSERT INTO `disciplinaturma` VALUES (1,1,1,1),(2,1,2,1);
/*!40000 ALTER TABLE `disciplinaturma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenador`
--

DROP TABLE IF EXISTS `coordenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordenador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenador`
--

LOCK TABLES `coordenador` WRITE;
/*!40000 ALTER TABLE `coordenador` DISABLE KEYS */;
INSERT INTO `coordenador` VALUES (1,'Tadeu'),(2,'Hugo');
/*!40000 ALTER TABLE `coordenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'Aluno'),(2,'Coordenador'),(3,'Atendente'),(4,'AdministradorGeral');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alunodisciplinaturma`
--

DROP TABLE IF EXISTS `alunodisciplinaturma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alunodisciplinaturma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `aluno_id` bigint(20) DEFAULT NULL,
  `disciplinaTurma_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_chdlvhkxm7mgc7fghxfjivx5x` (`aluno_id`),
  KEY `FK_mmfcdv4vbq5v8pffhqipb1ofc` (`disciplinaTurma_id`),
  CONSTRAINT `FK_mmfcdv4vbq5v8pffhqipb1ofc` FOREIGN KEY (`disciplinaTurma_id`) REFERENCES `disciplinaturma` (`id`),
  CONSTRAINT `FK_chdlvhkxm7mgc7fghxfjivx5x` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunodisciplinaturma`
--

LOCK TABLES `alunodisciplinaturma` WRITE;
/*!40000 ALTER TABLE `alunodisciplinaturma` DISABLE KEYS */;
INSERT INTO `alunodisciplinaturma` VALUES (1,'A',1,1),(2,'A',2,1),(3,'A',3,1),(4,'A',4,1),(5,'A',1,2);
/*!40000 ALTER TABLE `alunodisciplinaturma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionalidadeperfil`
--

DROP TABLE IF EXISTS `funcionalidadeperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionalidadeperfil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Funcionalidade_id` bigint(20) DEFAULT NULL,
  `perfil_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6qspxo6rl9uyruyn598phuqwc` (`Funcionalidade_id`),
  KEY `FK_mq1db266us0acm40adsvgw03n` (`perfil_id`),
  CONSTRAINT `FK_mq1db266us0acm40adsvgw03n` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`),
  CONSTRAINT `FK_6qspxo6rl9uyruyn598phuqwc` FOREIGN KEY (`Funcionalidade_id`) REFERENCES `funcionalidade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionalidadeperfil`
--

LOCK TABLES `funcionalidadeperfil` WRITE;
/*!40000 ALTER TABLE `funcionalidadeperfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionalidadeperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataFinal` date DEFAULT NULL,
  `dataInicial` date DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,'2015-07-15','2015-12-15','Primeiro Periodo 2015'),(2,'2015-08-03','2015-12-15','Segundo Periodo 2015');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Anderson Augusto Rodrigo Silva'),(2,'Fabricio Dias'),(3,'Lucas Hermano'),(4,'Rafael Cruz');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionalidade`
--

DROP TABLE IF EXISTS `funcionalidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionalidade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `Funcionalidade_id` bigint(20) DEFAULT NULL,
  `perfil_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2xb00ae64hdoypk7svnjv4xmx` (`Funcionalidade_id`),
  KEY `FK_sqyqogl7reyrxbe6ocj5lnupc` (`perfil_id`),
  CONSTRAINT `FK_sqyqogl7reyrxbe6ocj5lnupc` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`),
  CONSTRAINT `FK_2xb00ae64hdoypk7svnjv4xmx` FOREIGN KEY (`Funcionalidade_id`) REFERENCES `funcionalidade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionalidade`
--

LOCK TABLES `funcionalidade` WRITE;
/*!40000 ALTER TABLE `funcionalidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionalidade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-02 22:58:30
