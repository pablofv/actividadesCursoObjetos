use distribuidora;

insert into distribuidora.colegios(nombre, direccion) 
							values ('EEI Nº68 Gabriela Mistral', 'Profesor Simon 1463, Villa Ballester, Provincia Bs.As.'); -- EEI escuela de educación inicial
insert into distribuidora.colegios(nombre, direccion) 
							values ('EEI Nº47 Huestes Salteñas', 'Quintana 5895, Villa Ballester, Provincia Bs.As.');
insert into distribuidora.colegios(nombre, direccion) 
							values ('EEI Nº9 Dr. Pedro Ballester', 'Bv. Ballester 5428, Villa Ballester, Provincia Bs.As.');
insert into distribuidora.colegios(nombre, direccion) 
							values ('EES Nº44 Almafuerte', 'Rio Negro 2561, José León Suarez, Provincia Bs.As.'); -- EES escuela de educación secundaria
insert into distribuidora.colegios(nombre, direccion) 
							values ('EES Nº8 Esteban Echeverría', 'Rawson 1918, José León Suarez, Provincia Bs.As.');
insert into distribuidora.colegios(nombre, direccion) 
							values ('JI Nº908 Merceditas de San Martín', 'Ayacucho 3129, San Andrés, Provincia Bs.As.'); -- JI jardín de infantes

INSERT INTO distribuidora.productos(nombre, marca, tipoProducto, precioCosto, unidad, cantidadPorUnidad)
				/*1*/			values ('Leche descremada', 'La Serenísima', 'LACTEOS', 90, 'LT', 12);
INSERT INTO distribuidora.productos(nombre, marca, tipoProducto, precioCosto, unidad, cantidadPorUnidad)
				/*2*/			values ('Manzana', 'S/M', 'FRUTAS', 15, 'UNIDAD', 1); -- S/M -> Sin Marca
INSERT INTO distribuidora.productos(nombre, marca, tipoProducto, precioCosto, unidad, cantidadPorUnidad)
				/*3*/			values ('Pan', 'S/M', 'PANIFICADOS', 80, 'KG', 1);
INSERT INTO distribuidora.productos(nombre, marca, tipoProducto, precioCosto, unidad, cantidadPorUnidad)
				/*4*/			values ('Carne', 'S/M', 'CARNES', 700, 'KG', 1);
INSERT INTO distribuidora.productos(nombre, marca, tipoProducto, precioCosto, unidad, cantidadPorUnidad)
				/*5*/			values ('Anillos de Coco', 'Tia Maruca', 'PANIFICADOS', 88, 'KG', 0.25);
INSERT INTO distribuidora.productos(nombre, marca, tipoProducto, precioCosto, unidad, cantidadPorUnidad)
				/*6*/			values ('Naranja', 'Cepita', 'BEBIDAS', 120, 'LT', 1);

insert into distribuidora.facturas(fechaFactura, totalFacturado, idColegio) -- 1
							values('2021-11-13', null, 1);
insert into distribuidora.facturas(fechaFactura, totalFacturado, idColegio) -- 2
							values('2021-12-02', null, 6);
insert into distribuidora.facturas(fechaFactura, totalFacturado, idColegio) -- 3
							values('2022-02-25', null, 4);
insert into distribuidora.facturas(fechaFactura, totalFacturado, idColegio) -- 4
							values('2022-03-07', null, 2);
insert into distribuidora.facturas(fechaFactura, totalFacturado, idColegio) -- 5
							values('2022-05-23', null, 4);

insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(1, 1, 50, 110); -- 5500
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(1, 3, 20, 100); -- 2000
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(1, 4, 3, 1000); -- 3000
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(1, 6, 50, 150); -- 7500
                            /* fact 2 */
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(2, 1, 50, 110); -- 5500
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(2, 4, 3.9, 1000); -- 3900
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(2, 5, 100, 120); -- 12000
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(2, 6, 10, 150); -- 1500
                                /*fact3*/
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(3, 1, 100, 110); -- 11100
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(3, 2, 50, 25); -- 1250
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(3, 3, 137.5, 100); -- 13750
                                /* fact4*/
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(4, 4, 15, 1000); -- 15000
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(4, 5, 100, 120); -- 12000
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(4, 6, 26, 200); -- 5200
                                /*fact 5*/
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(5, 1, 50, 110); -- 5500
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(5, 2, 620, 25); -- 15500
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(5, 3, 20, 100); -- 2000
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(5, 4, 15, 1000); -- 15000
insert into distribuidora.itemfacturas(idFactura, idProducto, cantidadProducto, precioUnitario)
								values(5, 6, 10, 150); -- 1500














