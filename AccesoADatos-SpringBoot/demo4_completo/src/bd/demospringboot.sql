--
-- Creacion del esquema demospringboot
--

CREATE DATABASE  IF NOT EXISTS `demospringboot` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `demospringboot`;

--
-- Estructura de la tabla clientes
--

CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nif` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `claveseguridad` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Datos de ejemplo para la tabla clientes
--

INSERT INTO clientes(id, nif, nombre, apellidos, claveSeguridad, email) VALUES (1, '11111111A', 'Filemón', 'Pí', '1234', 'filemon.pi@tia.es');
INSERT INTO clientes(id, nif, nombre, apellidos, claveSeguridad, email) VALUES (2, '22222222B', 'Mortadelo', 'Ibáñez', '1234', 'mortadelo.ibanez@tia.es');
INSERT INTO clientes(id, nif, nombre, apellidos, claveSeguridad, email) VALUES (3, '33333333C', 'Vicente', 'Mondragón', '1234', 'vicente.mondragon@tia.es');
INSERT INTO clientes ( id, nif, nombre, apellidos, claveSeguridad, email) VALUES (4, '44444444D', 'Ayrton', 'Senna', '1234', 'ayrton.senna@f1.es');
INSERT INTO clientes( id, nif, nombre, apellidos, claveSeguridad, email)VALUES(5, 'B1111111A', 'Ibertrola', '-', '1234', '-');
INSERT INTO clientes ( id, nif, nombre, apellidos, claveSeguridad, email) VALUES (6, 'B2222222B', 'Gas Natural', '-', '1234', '-');
INSERT INTO clientes ( id, nif, nombre, apellidos, claveSeguridad, email) VALUES (7, 'B3333333C', 'Telefónica', '-', '1234', '-');
INSERT INTO clientes ( id, nif, nombre, apellidos, claveSeguridad, email) VALUES (8, 'B4444444D', 'Aguas de Valencia', '-', '1234', '-');
INSERT INTO clientes ( id, nif, nombre, apellidos, claveSeguridad, email) VALUES (9, 'B5555555E', 'Audi', '-', '1234', '-');
INSERT INTO clientes ( id, nif, nombre, apellidos, claveSeguridad, email) VALUES (10, 'B6666666F', 'BMW', '-', '1234', '-');
INSERT INTO clientes ( id, nif, nombre, apellidos, claveSeguridad, email) VALUES (11, 'B7777777G', 'PayPal', '-', '1234', '-');
INSERT INTO clientes ( id, nif, nombre, apellidos, claveSeguridad, email) VALUES (12, 'B8888888H', 'Ayuntamiento de Valencia', '-', '1234', '-');

--
-- Estructura de la tabla recomendaciones
--

CREATE TABLE `demospringboot`.`recomendaciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `observaciones` VARCHAR(500) NOT NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_recomendaciones1` (`idcliente`),  
  INDEX `fk_cliente_recomendacion_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_recomendacion`
    FOREIGN KEY (`idCliente`)
    REFERENCES `demospringboot`.`clientes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Datos de ejemplo para la tabla recomendaciones
--

INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES (1,'Nada que observar',1);
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES (2,'Sin comentarios',2);
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES (3, 'Realiza muchos pedidos',3);
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES (4,'No realiza pedidos.',4);
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES (5,'Solo dado de alta.',5);
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES ('6', 'Empresa', '6');
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES ('7', 'Empresa', '7');
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES ('8', 'Empresa de Valencia', '8');
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES ('9', 'Empresa de automoción', '9');
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES ('10', 'Empresa de automoción', '10');
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES ('11', 'Medio de pago', '11');
INSERT INTO `demospringboot`.`recomendaciones` (`id`, `observaciones`, `idcliente`) VALUES ('12', 'Ayuntamiento', '12');

	
--
-- Estructura de la tabla cuentas
--	
	
CREATE TABLE `demospringboot`.`cuentas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `banco` VARCHAR(4) NOT NULL,
  `sucursal` VARCHAR(4) NOT NULL,
  `dc` VARCHAR(2) NOT NULL,
  `numerocuenta` VARCHAR(10) NOT NULL,
  `saldoactual` FLOAT NOT NULL,
  `idcliente` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fg_cuentas_clientes_idx` (`idcliente` ASC) VISIBLE,
  CONSTRAINT `fg_cuentas_clientes`
    FOREIGN KEY (`idcliente`)
    REFERENCES `demospringboot`.`clientes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
	) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;	
	
--
-- Datos de ejemplo para la tabla cuentas
--		

INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (1, '1001', '1001', '11', '1000000001', 1500, 1);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (2, '1001', '1001', '11', '1000000003', -1200, 1);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (3, '1001', '1001', '11', '1000000002', 3500, 1);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (4, '1001', '1001', '11', '1000000004', 15340, 2);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (5, '1001', '1001', '11', '1000000005', 23729.23, 1);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (6, '1001', '1001', '11', '1000000006', 6500, 1);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (7, '1001', '1001', '11', '1000000007', 9500, 2);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (8, '1001', '1001', '11', '1000000008', 7500, 3);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (9, '1001', '1001', '11', '1000000009', 24650, 1);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (10, '1001', '1001', '11', '1000000010', -3500, 3);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (11, '1001', '2001', '22', '2000000001', 7530543.75, 5);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (12, '1001', '2001', '22', '2000000002', 15890345.87, 6);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (13, '1001', '2001', '22', '2000000003', 19396420.30, 7);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (14, '1001', '2001', '22', '2000000004', 1250345.23, 8);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (15, '1001', '2001', '22', '2000000005', 24387299.23, 9);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (16, '1001', '2001', '22', '2000000006', 15904387.45, 10);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (17, '1001', '2001', '22', '2000000007', 156398452.87, 10);
INSERT INTO cuentas (id,banco, sucursal, dc, numerocuenta, saldoactual, idcliente) VALUES (18, '1001', '2001', '22', '2000000008', 2389463.98, 11);
