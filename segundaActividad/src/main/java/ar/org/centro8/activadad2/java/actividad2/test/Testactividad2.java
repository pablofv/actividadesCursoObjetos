package ar.org.centro8.activadad2.java.actividad2.test;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.org.centro8.activadad2.java.actividad2.entities.Auto;
import ar.org.centro8.activadad2.java.actividad2.entities.Moto;
import ar.org.centro8.activadad2.java.actividad2.entities.Vehiculo;

public class Testactividad2 {
    //Hacemos la variable de ambito mas amplio
    static List<Vehiculo> colVehiculos = new ArrayList<>();
    public static void main(String[] args) {
        Auto auto1 = new Auto("Peugeot", "206", 200000d, 4);
        Moto moto1 = new Moto("Honda", "Titán", 60000d, "125c");
        Auto auto2 = new Auto("Peugeot", "208", 250000d, 5);
        Moto moto2 = new Moto("Yamaha", "YBR", 80500.5d, "160c");

        // que pasa si tengo 2 vehículos mas caros
        //Auto auto3 = new Auto("Peugeot", "207", 250000d, 5);


        //Agregamos los vehículos a la colección
        colVehiculos.add(auto1);
        colVehiculos.add(moto1);
        colVehiculos.add(auto2);
        colVehiculos.add(moto2);
        //colVehiculos.add(auto3);

        colVehiculos.forEach(System.out::println);

        System.out.println("\n\n=============================\n\n");

        vehiculoMasCaro(colVehiculos);

        vehiculoMasBarato(colVehiculos);

        vehiculosConLetraY(colVehiculos);
    
        System.out.println("\n\n=============================\n\n");
    
        ordenadosPorPrecioDesc(colVehiculos);
        
        System.out.println("\n\n=============================\n\n");

        ordenadosPorCompareTO(colVehiculos);
    }

    protected static void ordenadosPorCompareTO(List<Vehiculo> colVehiculos) {
        //Ordenados por compareTO (orden natural)
        System.out.println("Vehículos ordenados por orden natural (por marca,modelo,precio):");
        colVehiculos
                    .stream()
                    .sorted()
                    .forEach(System.out::println);
    }

    protected static void ordenadosPorPrecioDesc(List<Vehiculo> colVehiculos) {
        // Ordenados por precio, de mayor a menor
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        colVehiculos
                    .stream()
                    .sorted(Comparator.comparing(v->v.getPrecio()*-1))
                    .forEach(v->System.out.println(v.getMarca() + " " + v.getModelo()));
    }

    protected static void vehiculosConLetraY(List<Vehiculo> colVehiculos) {
        //El vehículo que contiene la letra Y
        List<Vehiculo> vehConLetraY;;
        DecimalFormat df=new DecimalFormat("###,###.00");
        vehConLetraY = colVehiculos
                                .stream()
                                .filter(p->p.getModelo().toLowerCase().contains("y")).toList();
        vehConLetraY.forEach(p->System.out.println("Vehículo que contiene en el modelo la letra 'Y': " + p.getMarca() + " " + p.getModelo() + " $" + df.format(p.getPrecio())));
    }

    protected static void vehiculoMasBarato(List<Vehiculo> colVehiculos) {
        //El vehículo mas barato
        Vehiculo vehMasBarato;
        vehMasBarato = colVehiculos
                                .stream()
                                .min(Comparator.comparingDouble(Vehiculo::getPrecio))
                                .get();
        
        System.out.println("Vehículo más barato: " + vehMasBarato.getMarca() + " " + vehMasBarato.getModelo());
    }

    protected static void vehiculoMasCaro(List<Vehiculo> colVehiculos) {
        //El vehículo mas caro
        //Consultar que pasa si hay mas de un vehículo mas caro.
        Vehiculo vehMasCaro;
        vehMasCaro = colVehiculos
                                .stream()
                                .max(Comparator.comparingDouble(Vehiculo::getPrecio))
                                .get();
        
        System.out.println("Vehículo más caro: " + vehMasCaro.getMarca() + " " + vehMasCaro.getModelo());
    }
}
