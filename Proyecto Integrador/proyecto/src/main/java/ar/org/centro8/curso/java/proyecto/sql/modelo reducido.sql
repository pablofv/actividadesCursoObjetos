DROP DATABASE if EXISTS distribuidora;
CREATE DATABASE distribuidora;
use distribuidora;

DROP TABLE if EXISTS productos;
DROP TABLE if EXISTS colegios;
-- DROP TABLE if EXISTS remitos;
DROP TABLE if EXISTS facturas;
DROP TABLE if EXISTS item_facturas;

create table productos(
	id int auto_increment primary key,
    nombre varchar(100) not null,
    marca varchar(40) not null,
    tipo_producto varchar(100) not null,
    precio_costo int not null,
    unidad varchar(100) not null,
    cantidad_por_unidad int not null
);

create table colegios(
    id int auto_increment primary key,
	nombre varchar(100) not null,
    direccion varchar(100) not null
);
/*   
create table remitos(
	id int auto_increment primary key,
    id_colegio int, -- colegio donde se entrega
    id_producto int,
    cantidad_producto int,
    fecha_remito timestamp
);
alter table remitos
add constraint foreign key(id_colegio) references colegios(id);
alter table remitos
add constraint foreign key(id_producto) references productos(id);
*/

create table facturas(
	id_factura int auto_increment primary key,
    fecha_factura timestamp,
    total_facturado double,
    id_colegio int /*a quien se le factura*/
);

alter table facturas
add constraint foreign key cf_facturas_colegio (id_colegio) references colegios(id);

create table itemFacturas(
	id_item int auto_increment primary key,
    id_factura int not null,
    id_producto int not null,
    cantidad_producto double not null,
    precio_unitario double not null
);

alter table itemFacturas
add constraint foreign key cf_items_facturas (id_factura) references facturas(id_factura),
-- alter table itemFacturas
add constraint foreign key cf_items_productos (id_producto) references productos(id);
