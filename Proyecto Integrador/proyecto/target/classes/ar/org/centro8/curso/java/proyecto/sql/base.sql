/*
DROP DATABASE if EXISTS distribuidora;
CREATE DATABASE distribuidora;
use distribuidora;
*/
DROP TABLE if EXISTS itemFacturas;
DROP TABLE if EXISTS facturas;
DROP TABLE if EXISTS colegios;
DROP TABLE if EXISTS productos;

create table productos(
	id int auto_increment primary key,
    nombre varchar(100) not null,
    marca varchar(40) not null,
    tipoProducto enum("CARNES", "VERDURAS", "PANIFICADOS", "FRUTAS", "LACTEOS", "BEBIDAS"),
    precioCosto int not null,
    unidad enum("KG", "LT", "UNIDAD"),
    cantidadPorUnidad int not null
);

create table colegios(
    id int auto_increment primary key,
	nombre varchar(100) not null,
    direccion varchar(100) not null
);

create table facturas(
	id int auto_increment primary key,
    fechaFactura timestamp,
    totalFacturado double,
    idColegio int /*a quien se le factura*/
);

alter table facturas
add constraint foreign key cf_factura_colegio (idColegio) references colegios(id);

create table itemFacturas(
	id int auto_increment primary key,
    idFactura int not null,
    idProducto int not null,
    cantidadProducto double not null,
    precioUnitario double not null
);

alter table itemFacturas
add constraint foreign key(idFactura) references facturas(id);
alter table itemFacturas
add constraint foreign key(idProducto) references productos(id);
