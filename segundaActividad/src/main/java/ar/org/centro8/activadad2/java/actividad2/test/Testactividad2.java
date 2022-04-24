package ar.org.centro8.activadad2.java.actividad2.test;



import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.activadad2.java.actividad2.entities.Auto;
import ar.org.centro8.activadad2.java.actividad2.entities.Moto;
import ar.org.centro8.activadad2.java.actividad2.entities.Vehiculo;

public class Testactividad2 {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Peugeot", "206", 200000d, 4);
        Moto moto1 = new Moto("Honda", "Titán", 60000d, "125c");
        Auto auto2 = new Auto("Peugeot", "208", 250000d, 5);
        Moto moto2 = new Moto("Yamaha", "Ybr", 80500.5d, "160c");

        List<Vehiculo> colVehiculos = new ArrayList<>();

        //Agregamos los vehículos a la colección

        colVehiculos.add(auto1);
        colVehiculos.add(moto1);
        colVehiculos.add(auto2);
        colVehiculos.add(moto2);

        // System.out.println(auto1);
        // System.out.println(moto1);
        // System.out.println(auto2);
        // System.out.println(moto2);

        colVehiculos.forEach(System.out::println);

    }



    

    

    
    
}
