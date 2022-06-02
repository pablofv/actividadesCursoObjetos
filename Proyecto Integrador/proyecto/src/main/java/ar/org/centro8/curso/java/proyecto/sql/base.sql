DROP DATABASE if EXISTS distribuidora;
CREATE DATABASE distribuidora;
use distribuidora;

DROP TABLE if EXISTS tipoProducto;
DROP TABLE if EXISTS productos;
DROP TABLE if EXISTS direccion;
DROP TABLE if EXISTS colegios;
DROP TABLE if EXISTS remitos;
DROP TABLE if EXISTS facturas;
DROP TABLE if EXISTS item_facturas;

create table tipoProducto(
	id int auto_increment primary key,
    tipo varchar(100) not null,
    sub_tipo varchar(100) not null
);

create table productos(
	id int auto_increment primary key,
    nombre varchar(100) not null,
    marca varchar(40) not null,
    id_tipo_producto int not null,
    precio_costo int not null,
    unidad varchar(100) not null,
    cantidad_por_unidad int not null
);

alter table productos
add constraint foreign key (id_tipo_producto) references tipoProducto(id);

create table direccion(
	id int auto_increment primary key,
	calle varchar(100),
    numero int,
    localidad varchar(100),
    codigoPostal int
);
create table colegios(
    id int auto_increment primary key,
	nombre varchar(100) not null,
    id_direccion int not null
);

alter table colegios
add constraint foreign key (id_direccion) references direccion(id);
   
create table remitos(
	id int auto_increment primary key,
    destinatario int, /* colegio donde se entrega */
    id_producto int,
    cantidad_producto int,
    fecha_remito timestamp
);
alter table remitos
add constraint foreign key(destinatario) references colegio(id);
alter table remitos
add constraint foreign key(id_producto) references productos(id);


create table facturas(
	id_factura int auto_increment primary key,
    fecha_factura timestamp,
    total_facturado double,
    facturadoA int /*a quien se le factura*/
);

create table itemFacturas(
	id_item int auto_increment primary key,
    id_factura int not null,
    id_producto int not null,
    cantidad_producto double not null,
    precio_unitario double not null
);

alter table itemFacturas
add constraint foreign key(id_factura) references facturas(id_factura);
alter table itemFacturas
add constraint foreign key(id_producto) references productos(id);
