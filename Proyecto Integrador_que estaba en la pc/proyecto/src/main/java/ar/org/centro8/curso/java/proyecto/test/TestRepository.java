package ar.org.centro8.curso.java.proyecto.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ar.org.centro8.curso.java.proyecto.connections.Connector;
import ar.org.centro8.curso.java.proyecto.entities.Colegio;
import ar.org.centro8.curso.java.proyecto.entities.Factura;
import ar.org.centro8.curso.java.proyecto.entities.ItemFactura;
import ar.org.centro8.curso.java.proyecto.entities.Producto;
import ar.org.centro8.curso.java.proyecto.enums.TipoProducto;
import ar.org.centro8.curso.java.proyecto.enums.Unidad;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_ColegioRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_ItemFacturaRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_ProductoRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ColegioRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.jdbc.FacturaRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ItemFacturaRepository;
import ar.org.centro8.curso.java.proyecto.repositorios.jdbc.ProductoRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestRepository {
    public static void main(String[] args) throws ParseException {
        Connection conn= Connector.getConnection();
        I_ColegioRepository cr = new ColegioRepository(conn);
        I_FacturaRepository fr = new FacturaRepository(conn);
        I_ItemFacturaRepository ifr = new ItemFacturaRepository(conn);
        I_ProductoRepository pr = new ProductoRepository(conn);


        // Colegio colegio = new Colegio("JI Nº902 Alfonsina Storni", "Capdevilla 5905, Villa Ballester, Provincia Bs.As.");
        // cr.save(colegio);
    
        // colegio = cr.getById(7);
        // colegio.setNombre("Jardín de infantes nº902");
        // cr.update(colegio);

        // // Mostrar todos
        // System.out.println("\nTodos\n");
        // cr.getAll().forEach(System.out::println);

        // //Buscar por dirección
        // System.out.println("\nBuscando por dirección:\n");
        // cr.getLikeDireccion("Simon").forEach(System.out::println);
        // cr.getLikeDireccion("Alsina").forEach(System.out::println);
        // cr.getLikeDireccion("Rawson").forEach(System.out::println);

        // //Buscar por nombre
        // System.out.println("\nBuscando por nombre:\n");
        // cr.getLikeNombre("68").forEach(System.out::println);
        // cr.getLikeNombre("47").forEach(System.out::println);
        // cr.getLikeNombre("502").forEach(System.out::println);

        // //Borramos un colegio
        // cr.remove(cr.getById(5));
        // // cr.remove(cr.getLikeDireccion("908"));
        
    
        // Producto producto = new Producto("Harina", "BlancaFlor", TipoProducto.PANIFICADOS, 20.5, Unidad.KG, 0.5);
        // pr.save(producto);

        // System.out.println("\nTodos\n");
        // pr.getAll().forEach(System.out::println);
    
        // producto = pr.getById(7);
        // producto.setNombre("Harina 000");
        // pr.update(producto);
 
        // System.out.println("\nTodos\n");
        // pr.getAll().forEach(System.out::println);
     
        // //Buscar por marca
        // System.out.println("\nBuscando por marca:\n");
        // pr.getLikeMarca("BlancaFlor").forEach(System.out::println);
        // pr.getLikeMarca("No hay").forEach(System.out::println);
        // pr.getLikeMarca("Cepita").forEach(System.out::println);

        // //Buscar por nombre
        // System.out.println("\nBuscando por nombre:\n");
        // pr.getLikeNombre("Pan").forEach(System.out::println);
        // pr.getLikeNombre("pan").forEach(System.out::println);
        // pr.getLikeNombre("Leche descremada").forEach(System.out::println);

        // //Borramos un producto
        // pr.remove(pr.getById(7));
        // System.out.println("For each de la colección: ");
        // pr.getAll().forEach(System.out::println);

        // Factura factura;
        // Date fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("27/10/2017 00:03");
        // System.out.println("To_string de la fecha: "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fecha));
        // try {
        //     Date fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("15/10/2017 13:03");
        //     factura = new Factura(fecha, 2);
        //     // System.out.println("La factura creada es: " + factura);
        //     fr.save(factura);
        // } catch (Exception ex) {
        //     System.out.println(ex);
        // }

        // // Actualizar factura
        // factura = fr.getById(6);
        // factura.setTotalFacturado(20000);
        // fr.update(factura);

        // // Mostrar todos
        // System.out.println("\nTodos\n");
        // fr.getAll().forEach(System.out::println);

        // //Buscar por 
        // System.out.println("\nBuscando por idColegio:\n");
        // fr.getByIdColegio(2).forEach(System.out::println);
        System.out.println("\nBuscando por fecha:\n");
        Date fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("23/05/2022 00:00");
        fr.getByFecha(fecha).forEach(System.out::println);
        // System.out.println("\nBuscando por Id:\n");
        // System.out.println(fr.getById(2));



        // ItemFactura itemFactura = new ItemFactura(6, 2, 3, 25);
        // ifr.save(itemFactura);
        // itemFactura = new ItemFactura(6, 4, 2, 12.5);
        // ifr.save(itemFactura);

        // // Actualizamos un item
        // itemFactura = ifr.getById(21);
        // itemFactura.setPrecioUnitario(22.5);
        // ifr.update(itemFactura);

        // // Buscar por idFactura
        // System.out.println("\nBuscando por idFactura:\n");
        // ifr.getByIdFactura(2).forEach(System.out::println);

        // // Buscar por idProducto
        // System.out.println("\nBuscando por idProducto:\n");
        // ifr.getByIdProducto(6).forEach(System.out::println);

        // // Los itemFactura
        // System.out.println("For each de la colección: ");
        // ifr.getAll().forEach(System.out::println);
    
        // // Borrar los item de la factura 6 para luego borrar la factura
        // itemFactura = ifr.getById(21);
        // ifr.remove(itemFactura);
        // itemFactura = ifr.getById(20);
        // ifr.remove(itemFactura);


        // // Las facturas
        // System.out.println("For each de la colección: ");
        // fr.getAll().forEach(System.out::println);

        //Borramos una factura luego de cargar y borrarle items
        // fr.remove(fr.getById(6));

        // System.out.println("For each de la colección: ");
        // fr.getAll().forEach(System.out::println);



    }
}
