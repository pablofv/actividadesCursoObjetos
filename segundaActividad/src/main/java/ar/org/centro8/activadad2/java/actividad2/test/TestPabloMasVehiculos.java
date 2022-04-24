package ar.org.centro8.activadad2.java.actividad2.test;

import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.activadad2.java.actividad2.entities.Auto;
import ar.org.centro8.activadad2.java.actividad2.entities.Moto;
import ar.org.centro8.activadad2.java.actividad2.entities.Vehiculo;
import ar.org.centro8.activadad2.java.actividad2.test.Testactividad2;

public class TestPabloMasVehiculos {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Peugeot", "206", 200000d, 4);
        Auto auto2 = new Auto("Peugeot", "208", 250000d, 5);
        Auto auto3 = new Auto("Fiat", "Precio 8", 1000000d, 5);
        Auto auto4 = new Auto("Vw", "Precio 6", 1300000d, 4);
        Auto auto5 = new Auto("Audi", "Precio 2", 2300000d, 4);
        Auto auto6 = new Auto("Alfa", "Precio 4", 1800000d, 5);
        Auto auto7 = new Auto("Audi", "A4 Precio 1", 2600000d, 4);
        Auto auto8 = new Auto("Audi", "A3 Precio 3", 2200000d, 5);
        Auto auto9 = new Auto("Fiat", "Precio 8", 900000d, 5);
        Auto auto0 = new Auto("Fiat", "Precio 8", 700000d, 5);

        Moto moto1 = new Moto("Honda", "Titán", 60000d, "125c");
        Moto moto2 = new Moto("Yamaha", "YBR", 80500.5d, "160c");
        Moto moto3 = new Moto("Ducati", "Precio 5", 1550000.30d, "160c");
        Moto moto4 = new Moto("kawasaki", "Precio 7", 1200000d, "160c");
        Moto moto5 = new Moto("Zanella", "Precio 9", 350000d, "160c");
        Moto moto6 = new Moto("Zanella", "Smash Y Precio 14", 50000d, "160c");

        // que pasa si tengo 2 vehículos mas caros
        //Auto auto3 = new Auto("Peugeot", "207", 250000d, 5);

        List<Vehiculo> colVehiculos = new ArrayList();

        //Agregamos los vehículos a la colección
        colVehiculos.add(auto1);
        colVehiculos.add(moto1);
        colVehiculos.add(auto2);
        colVehiculos.add(moto2);
        colVehiculos.add(auto3);
        colVehiculos.add(auto4);
        colVehiculos.add(auto5);
        colVehiculos.add(auto6);
        colVehiculos.add(moto3);
        colVehiculos.add(moto4);
        colVehiculos.add(moto5);
        colVehiculos.add(auto7);
        colVehiculos.add(auto8);
        colVehiculos.add(moto6);
        colVehiculos.add(auto9);
        colVehiculos.add(auto0);

        colVehiculos.forEach(System.out::println);

        System.out.println("\n\n=============================\n\n");

        ar.org.centro8.activadad2.java.actividad2.test.Testactividad2.vehiculoMasCaro(colVehiculos);

        ar.org.centro8.activadad2.java.actividad2.test.Testactividad2.vehiculoMasBarato(colVehiculos);

        ar.org.centro8.activadad2.java.actividad2.test.Testactividad2.vehiculosConLetraY(colVehiculos);
    
        System.out.println("\n\n=============================\n\n");
    
        ar.org.centro8.activadad2.java.actividad2.test.Testactividad2.ordenadosPorPrecioDesc(colVehiculos);
        
        System.out.println("\n\n=============================\n\n");

        ar.org.centro8.activadad2.java.actividad2.test.Testactividad2.ordenadosPorCompareTO(colVehiculos);
    }
    
}
