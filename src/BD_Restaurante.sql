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
morada y pollo', '6', 2, '');
    
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
  `id_restaurante` int NOT NULL AUTO_INCREMENT,
  `restaurante` varchar(100) NOT NULL,
  `direccion_restaurante` varchar(100),
  `telefono_restaurante` varchar(50),
  `horario_LV` varchar(30),
  `horario_S` varchar(30),
  `correo_restaurante` varchar(100),
  PRIMARY KEY (`id_restaurante`)
);

insert into restaurantes values (1, 'Restaurante Paseo Colon', 'Frente al Hotel 
Ambasador sobre el Paseo Colon, Calle 28, San Jose', '+506 2220-2530', '10:00am-9:00pm',
'10:00am-8:00pm', 'restpaseocolon@patxis.com');

insert into restaurantes values (2, 'Restaurante Parque de la Paz', '25 metros 
al norte de la Rotonda de la Y Griega', '+506 2220-2632', '10:00am-9:00pm',
 '10:00am-8:00pm', 'restparquepaz@patxis.com');

insert into restaurantes values (3, 'Restaurante Escazú', 'Frente Perimercado 
Los Anonos, Carretera vieja Escazu', '+506 2220-2735', '10:00am-9:00pm',
 '10:00am-8:00pm', 'restescazu@patxis.com');
 
 select * from restaurantes;

  CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `dia_reserva` varchar(50),
  `hora_reserva` varchar(50),
  `nombre_reserva` varchar(100) NOT NULL,
  `cantidad_reserva` int(10),
  `telefono_reserva` varchar(50),
  `id_restaurante` int(11) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  CONSTRAINT `fk_reserva_restaurante` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurantes` (`id_restaurante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

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



INSERT INTO `roles` VALUES (1,"Presidente");
INSERT INTO `roles` VALUES (2,"Vice-Presidente");
INSERT INTO `usuarios` VALUES (1,"Juan","Solis","Mayorga", "Urb. Fabiola",456123132,"jsolis@mail.com","*******",1);
INSERT INTO `usuarios` VALUES (2,"Carlos","Mata","Seaes", "Cartago",654013232,"cmata@mail.com","*******",2);






SELECT * FROM `usuarios`;

