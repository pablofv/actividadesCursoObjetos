package ar.org.centro8.activadad2.java.actividad2.test;



import java.util.ArrayList;
import java.util.Comparator;
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

        // que pasa si tengo 2 vehículos mas caros
        //Auto auto3 = new Auto("Peugeot", "207", 250000d, 5);

        List<Vehiculo> colVehiculos = new ArrayList<>();

        //Agregamos los vehículos a la colección
        colVehiculos.add(auto1);
        colVehiculos.add(moto1);
        colVehiculos.add(auto2);
        colVehiculos.add(moto2);
        //colVehiculos.add(auto3);

        colVehiculos.forEach(System.out::println);

        System.out.println("\n\n=============================\n\n");

        //Próxima tanda de resultados

        // Vehículo más caro: Peugeot 208
        // Vehículo más barato: Honda Titan
        // Vehículo que contiene en el modelo la letra ‘Y’: Yamaha YBR $80.500,50

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
