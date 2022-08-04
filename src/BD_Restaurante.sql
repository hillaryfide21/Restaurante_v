CREATE DATABASE Restaurantev6;
use Restaurantev6;

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(50) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ;

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(45) NOT NULL,
  `apellido1_usuario` varchar(45) NOT NULL,
  `apellido2_usuario` varchar(45),
  `direccion_usuario` varchar(45),
  `telefono_usuario` varchar(45),
  `correo_usuario` varchar(75) DEFAULT NULL,
  `contrasena_usuario` varchar(75) DEFAULT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `fk_usuarios_roles` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;


CREATE TABLE `puestos` (
  `id_puesto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_puesto` varchar(50) NOT NULL,
  `detalle_puesto` varchar(500) NOT NULL,
  `requisito_puesto` varchar(500) NOT NULL,
  PRIMARY KEY (`id_puesto`)
) ;

insert into puestos values (1, 'Contabilidad', 'Contabilidad y finanzas', 'Requisitos');

CREATE TABLE `solicitudes` (
  `id_solicitud` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fecha_solicitud` date,
  `id_usuario` int(11) NOT NULL,
  `id_puesto` int(11) NOT NULL,
   CONSTRAINT `fk_solicitud_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
   CONSTRAINT `fk_solicitud_puestos` FOREIGN KEY (`id_puesto`) REFERENCES `puestos` (`id_puesto`) ON DELETE NO ACTION ON UPDATE NO ACTION
 );
  
CREATE TABLE CATEGORIAS(
	id_categoria int not null auto_increment,
	primary key(id_categoria),
	nombre_categoria varchar(50));

/*CATEGORIAS*/
insert into categorias values (1, 'Entradas', 'entradas');
insert into categorias values (2, 'Ensaladas', 'ensaladas');
insert into categorias values (3, 'Pizzas', 'pizzas');
insert into categorias values (4, 'Pastas', 'pastas');
insert into categorias values (5, 'Bebidas', 'bebidas');

CREATE TABLE MENU(
	id_producto int not null auto_increment,
	primary key (id_producto),
	nombre_producto varchar(100),
	detalle_producto varchar(200),
	precio_producto int,
	id_categoria int not null,
	imagen_producto varchar(100),
	CONSTRAINT `fk_menu_categorias` FOREIGN KEY (`id_categoria`) REFERENCES
	`categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION);
 
/*PRODUCTOS*/
insert into menu values (1, 'Pizza Nórdica', 'Deliciosa pizza con base de crema, salmon, 
cebolla cruda, alcaparras, cebollino y un toque de salsa de aguacate de la casa', 10, 3, 'pizza-nordica.jpg');

insert into menu values (2, 'Pizza Veggie', 'Deliciosa pizza con chile, tomate, 
cebolla y aceitunas', 12, 3, 'pizza-veggie.jpg');

insert into menu values (3, 'Pizza Capresse', 'Deliciosa pizza con tomate, 
orégano y albahaca', 9, 3, 'pizza-capresse.jpg');

insert into menu values (4, 'Ensalada Cesar', 'Deliciosa ensalada de espinacas, cebolla
morada y pollo', '6', 2, 'ensalada-cesar.jpg');

CREATE TABLE `ordenes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` varchar(100) DEFAULT NULL,
  `total` double NOT NULL,
  `usuario_id_usuario` bigint DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_recibida` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `detalles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `cantidad` double DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `orden_id` int DEFAULT NULL,
  `id_producto_id_producto` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orden_detalles_idx` (`orden_id`),
  CONSTRAINT `fk_orden_detalles` FOREIGN KEY (`orden_id`) REFERENCES `ordenes` (`id`)
);

    
  CREATE TABLE `cupones` (
  `id_cupon` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cupon` varchar(50) NOT NULL,
  `detalle_cupon` varchar(500) NOT NULL,
  `tipo_cupon` varchar(500) NOT NULL,
  PRIMARY KEY (`id_cupon`)
) ;

INSERT INTO cupones VALUES (1, 'Segundo a mitad de precio', 'Segunda pizza de la casa a mitad de precio en tu proxima compra', 'Rebaja')
, (2, '2 x 1', 'Compra dos pastas pomodoro por el precio de 1 en tu proxima compra', 'Doble producto')
, (3, '30% de descuento', 'Pasta pesto con 30% de descuento en tu proxima compra', '% descuento');

  CREATE TABLE `contacto` (
  `id_contactenos` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_contactenos` varchar(30),
  `nombre_contactenos` varchar(100) NOT NULL,
  `telefono_contactenos` varchar(50),
  `correo_contactenos` varchar(50),
  `asunto_contactenos` varchar(100),
  `mensaje_contactenos` varchar(250),
  PRIMARY KEY (`id_contactenos`)
);

INSERT INTO contacto VALUES (1, '21/3/2022', 'Hillary Madriz', '8888-8888', 'h@mail.com', 'Sugerencia', 'Agradecería puedan tener un menu de ninos')
, (2, '21/7/2022', 'Mariana Perez', '8778-8888', 'm@mail.com', 'Evento', 'Quisiera saber si puedo reservar para un evento ya que no veo esa opcion en la página');

  CREATE TABLE `restaurantes` (
  `id_restaurante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_restaurante` varchar(100) NOT NULL,
  `direccion_restaurante` varchar(500),
  `telefono_restaurante` varchar(50),
  `horario_restaurante` varchar(500),
  `correo_restaurante` varchar(500),
  `horarioReserv` int(50),
  PRIMARY KEY (`id_restaurante`),
  CONSTRAINT `fk_solicitud_horarios` FOREIGN KEY (`horarioReserv`) REFERENCES `horarioReservas` (`id_reserva_horario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;
SELECT * from restaurantes;


insert into restaurantes values (1, 'Restaurante Paseo Colon', 'Frente al Hotel 
Ambasador sobre el Paseo Colon, Calle 28, San Jose', '+506 2220-2530', '10:00am-9:00pm', 'restpaseocolon@patxis.com',1);

insert into restaurantes values (2, 'Restaurante Parque de la Paz', '25 metros 
al norte de la Rotonda de la Y Griega', '+506 2220-2632', '10:00am-9:00pm', 'restparquepaz@patxis.com',2);

insert into restaurantes values (3,'Restaurante Guanacaste', '100 mts sur del palo de mango', '+506 4567-7862', '10:00am-9:00pm', 'restescazu@patxis.com',2);

  CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL,
  `dia_reserva` varchar(50),
  `hora_reserva` varchar(50),
  `nombre_reserva` varchar(100) NOT NULL,
  `cantidad_reserva` int(10),
  `telefono_reserva` varchar(50),
  `id_restaurante` int(11) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  CONSTRAINT `fk_reserva_restaurante` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurantes` (`id_restaurante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

INSERT INTO reservas values (1,'Lunes','10:34:09 AM','Juan Rodriguez',5,4543123,1);
Select * from reservas;

  CREATE TABLE `pedidos` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_pedido` varchar(100) NOT NULL,
  `telefono_pedido` varchar(50),
  `fecha_pedido` datetime,
  `id_restaurante` int(11) NOT NULL,
  PRIMARY KEY (`id_pedido`),
  CONSTRAINT `fk_pedido_restaurante` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurantes` (`id_restaurante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

  CREATE TABLE `productos_x_pedido` (
  `id_pedido_x_producto` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad_pedido` int,
  `detalle pedido` varchar(500),
  PRIMARY KEY (`id_pedido_x_producto`),
   CONSTRAINT `fk_productos_x_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
   CONSTRAINT `fk_pedido_x_pedido` FOREIGN KEY (`id_producto`) REFERENCES `menu` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

CREATE TABLE `horarioReservas`(
	`id_reserva_horario` int(50) not null auto_increment,
    `horario1` boolean, -- 11-12
    `horario2` boolean, -- 12-13
    `horario3` boolean, -- 13-14
    `horario4` boolean, -- 18-19
    `horario5` boolean, -- 19-20
    `horario6` boolean, -- 20-21
    `horario1Cant` int(10), -- cant max 6 reservas por hora
    `horario2Cant` int(10),
    `horario3Cant` int(10),
    `horario4Cant` int(10),
    `horario5Cant` int(10),
    `horario6Cant` int(10),
    PRIMARY KEY (`id_reserva_horario`)
);
insert into horarioReservas values (3,1,1,1,1,1,1,6,6,6,6,6,6);
SELECT * from horarioReservas;

INSERT INTO `roles` VALUES (1,"Presidente");
INSERT INTO `roles` VALUES (2,"Vice-Presidente");
INSERT INTO `usuarios` VALUES (1,"Juan","Solis","Mayorga", "Urb. Fabiola",456123132,"jsolis@mail.com","*******",1);
INSERT INTO `usuarios` VALUES (2,"Carlos","Mata","Seaes", "Cartago",654013232,"cmata@mail.com","*******",2);






SELECT * FROM `usuarios`;

