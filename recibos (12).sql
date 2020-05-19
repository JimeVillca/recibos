-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2020 a las 00:28:31
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recibos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE `concepto` (
  `idConcepto` int(11) NOT NULL,
  `fechaAlta` date DEFAULT NULL,
  `Concepto` varchar(50) DEFAULT NULL,
  `tipoConcepto` varchar(1) DEFAULT NULL,
  `idlote_recibos` int(11) DEFAULT NULL,
  `importe` int(11) DEFAULT NULL,
  `idRecibo` int(11) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  `NroLoteProcesado` int(11) DEFAULT NULL,
  `periodo` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `concepto`
--

INSERT INTO `concepto` (`idConcepto`, `fechaAlta`, `Concepto`, `tipoConcepto`, `idlote_recibos`, `importe`, `idRecibo`, `idusuario`, `NroLoteProcesado`, `periodo`) VALUES
(1, '2019-10-27', 'D', 'H', NULL, 1500, NULL, 1, NULL, ''),
(2, '2019-10-27', NULL, 'D', NULL, 25, NULL, 1, 1, ''),
(3, '2019-10-27', NULL, 'D', NULL, 25, NULL, 1, NULL, ''),
(4, '2019-10-27', 'H', 'H', NULL, 1500, NULL, 41, NULL, ''),
(5, '2019-10-27', 'D', 'D', NULL, 25, NULL, 1, NULL, ''),
(6, '2019-10-27', 'D', 'D', NULL, 25, NULL, 1, NULL, ''),
(7, '2019-10-27', 'H', 'H', NULL, 1500, NULL, 41, NULL, ''),
(8, '2019-10-27', 'D', 'D', NULL, 25, NULL, 41, NULL, ''),
(9, '2019-10-27', 'D', 'D', NULL, 25, NULL, 1, NULL, ''),
(10, '2019-10-27', 'Sueldo Basico', 'H', NULL, 1500, NULL, 40, NULL, ''),
(11, '2019-10-27', 'Jubilacion', 'D', NULL, 25, NULL, 40, NULL, ''),
(12, '2019-10-27', 'Obra social', 'D', NULL, 25, NULL, 40, NULL, ''),
(13, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, NULL, ''),
(14, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, NULL, ''),
(15, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, NULL, ''),
(16, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 1, ''),
(17, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 1, ''),
(18, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 1, ''),
(19, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 1, ''),
(20, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 1, ''),
(21, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 1, ''),
(22, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 2, ''),
(23, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 2, ''),
(24, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 2, ''),
(25, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 2, ''),
(26, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 2, ''),
(27, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 2, ''),
(28, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 2, ''),
(29, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 2, ''),
(30, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 2, ''),
(31, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 3, ''),
(32, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 3, ''),
(33, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 3, ''),
(34, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 3, ''),
(35, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 3, ''),
(36, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 3, ''),
(37, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 3, ''),
(38, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 3, ''),
(39, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 3, ''),
(40, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 3, ''),
(41, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 3, ''),
(42, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 3, ''),
(43, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 3, ''),
(44, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 3, ''),
(45, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 3, ''),
(46, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 3, ''),
(47, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 3, ''),
(48, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 3, ''),
(49, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 5, ''),
(50, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 5, ''),
(51, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 5, ''),
(52, '2019-11-02', 'Sueldo Basico', 'H', NULL, 1500, NULL, NULL, 7, ''),
(53, '2019-11-02', 'Jubilacion', 'D', NULL, 25, NULL, NULL, 7, ''),
(54, '2019-11-02', 'Obra social', 'D', NULL, 25, NULL, NULL, 7, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `firma`
--

CREATE TABLE `firma` (
  `idfirma` int(11) NOT NULL,
  `CodigoFirma` varchar(80) DEFAULT NULL,
  `IdUsuario` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `FechaAlta` date NOT NULL,
  `FechaBaja` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `firma`
--

INSERT INTO `firma` (`idfirma`, `CodigoFirma`, `IdUsuario`, `usuario`, `FechaAlta`, `FechaBaja`) VALUES
(6, 'pruebafirma', 40, 'USUARIOPRUEBA', '2019-10-11', NULL),
(7, 'prueba', 42, '0', '2019-10-12', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `firmausuario`
--

CREATE TABLE `firmausuario` (
  `idFirmaUsuario` int(11) NOT NULL,
  `firmaAdministrador` int(11) NOT NULL,
  `firmaUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lote_recibido`
--

CREATE TABLE `lote_recibido` (
  `idLote` int(11) NOT NULL,
  `fechaImportacion` date NOT NULL,
  `Periodo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibos`
--

CREATE TABLE `recibos` (
  `idRecibos` int(11) NOT NULL,
  `fechaAlta` date NOT NULL,
  `idusuario` int(11) NOT NULL,
  `ubicacion` varchar(50) DEFAULT NULL,
  `idFirmaUsuario` int(11) DEFAULT NULL,
  `archivo` varchar(50) NOT NULL,
  `idFirmaAdm` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recibos`
--

INSERT INTO `recibos` (`idRecibos`, `fechaAlta`, `idusuario`, `ubicacion`, `idFirmaUsuario`, `archivo`, `idFirmaAdm`) VALUES
(1, '2020-02-25', 1, NULL, NULL, 'Recibo1 194724', NULL),
(2, '2020-02-25', 1, NULL, NULL, 'Recibo1 194815', NULL),
(3, '2020-02-25', 41, NULL, NULL, 'Recibo41 194817', NULL),
(4, '2020-02-25', 1, NULL, NULL, 'Recibo1 194819', NULL),
(5, '2020-02-25', 1, NULL, NULL, 'Recibo1 194820', NULL),
(6, '2020-02-25', 41, NULL, NULL, 'Recibo41 194821', NULL),
(7, '2020-02-25', 41, NULL, NULL, 'Recibo41 194822', NULL),
(8, '2020-02-25', 1, NULL, NULL, 'Recibo1 194823', 6),
(9, '2020-02-25', 40, NULL, NULL, 'Recibo40 194823', NULL),
(10, '2020-02-25', 40, NULL, NULL, 'Recibo40 194824', 6),
(11, '2020-02-25', 40, NULL, NULL, 'Recibo40 194825', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `Descripcion` varchar(75) DEFAULT NULL,
  `FechaAlta` date DEFAULT NULL,
  `FechaBaja` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idrol`, `Descripcion`, `FechaAlta`, `FechaBaja`) VALUES
(21, 'Administrador', '2019-09-08', NULL),
(22, 'usuario consulta', '2019-09-08', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas_pendientes`
--

CREATE TABLE `tareas_pendientes` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` varchar(150) NOT NULL,
  `Terminada` bit(1) NOT NULL,
  `Fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tareas_pendientes`
--

INSERT INTO `tareas_pendientes` (`id`, `Nombre`, `Descripcion`, `Terminada`, `Fecha`) VALUES
(1, 'prueba', 'prueba', b'1', NULL),
(2, 'prueba', 'prueba', b'1', NULL),
(3, 'organizacion', '', b'1', NULL),
(4, 'organizacion', '', b'1', NULL),
(5, '', '', b'0', NULL),
(6, '', '', b'0', NULL),
(7, '', '', b'0', NULL),
(8, '', '', b'0', NULL),
(9, '', '', b'0', NULL),
(10, '', '', b'0', NULL),
(11, '', '', b'0', NULL),
(12, '', '', b'0', NULL),
(13, '', '', b'0', NULL),
(14, '', '', b'0', NULL),
(15, '', '', b'0', NULL),
(16, '', '', b'0', NULL),
(17, '', '', b'0', NULL),
(18, '', '', b'0', NULL),
(19, '', '', b'0', NULL),
(20, 'prueba', 'asdsa', b'1', NULL),
(21, 'prueba', 'asdsa', b'1', NULL),
(22, 'prueba', 'asdsa', b'1', NULL),
(23, 'prueba', 'asdsa', b'1', NULL),
(24, 'prueba', 'asdsa', b'1', NULL),
(25, 'prueba', 'asdsa', b'1', NULL),
(26, 'Registros simples', 'prueba', b'1', NULL),
(27, 'Registros simples', 'prueba', b'1', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idtipodocumento` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `abreviacion` varchar(10) DEFAULT NULL,
  `fechaAlta` date DEFAULT NULL,
  `fechaBaja` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`idtipodocumento`, `descripcion`, `abreviacion`, `fechaAlta`, `fechaBaja`) VALUES
(1, 'Clave Única de Identificación Tributaria', 'CUIT', '2019-10-25', NULL),
(2, 'Documento Nacional de Identidad', 'DNI', '2019-09-09', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellido` varchar(60) DEFAULT NULL,
  `idTipoDocumento` int(11) DEFAULT NULL,
  `numeroDocumento` varchar(15) DEFAULT NULL,
  `user` varchar(30) DEFAULT NULL,
  `contrasena` varchar(20) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `FechaAlta` date DEFAULT NULL,
  `idFirma` int(11) DEFAULT NULL,
  `FechaBaja` date DEFAULT NULL,
  `idRol` int(11) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `idTipoDocumento`, `numeroDocumento`, `user`, `contrasena`, `email`, `FechaAlta`, `idFirma`, `FechaBaja`, `idRol`, `cargo`) VALUES
(1, 'sda', 'sad', 2, '213213', 'jo', 'a', 'a', '2019-09-02', 1, '2019-10-07', 21, ''),
(40, 'Usuario', 'Prueba', 2, '21023612', 'prueba', 'abc123', 'prueba@gmail.com', '2019-09-09', NULL, NULL, 21, ''),
(41, 'dsfds', 'sfsdf', 2, '45435', 'mar', 'w', 'ww', '2019-09-02', NULL, NULL, 21, ''),
(42, 'dsafsa', 'dsfsDSAD', 2, '123', 'WQEW', '12', '21', '2019-09-23', NULL, NULL, 0, ''),
(43, 'ASDSAD', 'ASDA', 2, '111', 'SAD', 'SAS', '21', '2019-09-23', NULL, NULL, 0, ''),
(44, 'Daniel', 'Lopez', 2, '123293248', 'danielop', 'lop', '21', '2019-10-05', NULL, NULL, 0, ''),
(45, 'Dario', 'Nuverio', 2, '23345347', 'dash', 'hup', '21', '2019-10-05', NULL, NULL, 0, ''),
(46, 'Javier', 'Uport', 2, '23432987', 'uportasda', 'asdasd', '21', '2019-10-05', NULL, NULL, 0, ''),
(47, 'Ignacio', 'Omio', 2, '24234090', 'lip', 'lip', '21', '2019-10-05', NULL, NULL, 22, ''),
(48, 'Omar', 'Chavez', 2, '2398309', 'om', 'om', '21', '2019-10-05', NULL, NULL, 0, ''),
(49, 'HHJAS', 'SDFS', 2, '342423', 'SKLJDKAL', 'KLASJDLKA', '21', '2019-10-05', NULL, NULL, 0, ''),
(50, 'HHGJ', 'JHGJ', 2, '765764', 'JKHGHJ', 'JKGH', '21', '2019-10-05', NULL, '2019-10-07', 0, ''),
(51, 'iHGAJSD', 'JHGADJAS', 2, '67579382', 'KLAJDLASLSAJDKL', 'JHSAKDAHS', '21', '2019-10-05', NULL, NULL, 0, ''),
(52, 'aloskp', 'lakdlañ', 2, '879769', 'ma,nsda', 'jahsjdkahs', '21', '2019-10-05', NULL, '2019-10-07', 0, ''),
(53, 'hgfrths', 'hqgwdqwwq', 2, '545', '45fghf', 'dfgfdg', '21', '2019-10-05', NULL, NULL, 0, ''),
(54, 'Prueba', 'usuario', 2, '1231132', 'admin', '123456', '21', '2019-10-07', NULL, NULL, 0, ''),
(55, 'jhgthj', 'bnmbnm', 2, '65675765', 'ghjgh', 'hghjgh', '21', '2019-10-07', NULL, NULL, 0, ''),
(56, 'Claudio', 'Tab', 2, '29189128', 'clautab', 'popcha', 'jhsanb@gmail.com', '2019-10-07', NULL, NULL, 21, '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `firma`
--
ALTER TABLE `firma`
  ADD PRIMARY KEY (`idfirma`),
  ADD KEY `idusuario` (`IdUsuario`);

--
-- Indices de la tabla `firmausuario`
--
ALTER TABLE `firmausuario`
  ADD PRIMARY KEY (`idFirmaUsuario`);

--
-- Indices de la tabla `lote_recibido`
--
ALTER TABLE `lote_recibido`
  ADD PRIMARY KEY (`idLote`);

--
-- Indices de la tabla `recibos`
--
ALTER TABLE `recibos`
  ADD PRIMARY KEY (`idRecibos`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idrol`);

--
-- Indices de la tabla `tareas_pendientes`
--
ALTER TABLE `tareas_pendientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idtipodocumento`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `firma`
--
ALTER TABLE `firma`
  MODIFY `idfirma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `firmausuario`
--
ALTER TABLE `firmausuario`
  MODIFY `idFirmaUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `lote_recibido`
--
ALTER TABLE `lote_recibido`
  MODIFY `idLote` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recibos`
--
ALTER TABLE `recibos`
  MODIFY `idRecibos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `tareas_pendientes`
--
ALTER TABLE `tareas_pendientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `firma`
--
ALTER TABLE `firma`
  ADD CONSTRAINT `idusuario` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`idusuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
