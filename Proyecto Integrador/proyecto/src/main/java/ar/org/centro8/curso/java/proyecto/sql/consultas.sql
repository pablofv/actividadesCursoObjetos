use distribuidora;

select *
from colegios;

select *
from facturas;

select *
from itemFacturas;

select *
from productos;

-- Actualizamos el total de las facturas
update facturas f
set totalFacturado = (select sum(cantidadProducto * precioUnitario)
					  from itemFacturas ifa
                      where ifa.idFactura = f.id)
;

-- Total facturado por colegio
select c.id, c.nombre, sum(f.totalFacturado) total_factura
from facturas f join colegios c on f.idColegio = c.id
group by c.id, c.nombre
order by c.id;
;

-- Los productos de cada factura
select f.id, f.fechaFactura, p.nombre producto_facturado
from facturas f join itemFacturas ifa on f.id = ifa.idFactura
				join productos p on ifa.idProducto = p.id;
