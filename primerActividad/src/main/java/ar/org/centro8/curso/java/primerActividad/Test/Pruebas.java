/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.org.centro8.curso.java.primerActividad.Test;

import ar.org.centro8.curso.java.primerActividad.Entities.Clasico;
import ar.org.centro8.curso.java.primerActividad.Entities.Nuevo;

/**
 *
 * @author pablo
 */
public class Pruebas {
    public static void main(String[] args) {
        Nuevo autoNuevo;
        Clasico autoClasico;
        
        autoNuevo = new Nuevo("Rojo", "Ford", "Fiesta ST", "Pionner");
        autoClasico = new Clasico("Blanco", "Renault", "Torino");
        
        System.out.println("Los autos luego de construirlos");
        System.out.println(autoNuevo);
        System.out.println(autoClasico);

        // Cambiamos las radios a los autos
        autoNuevo.asignarUnaRadio("Sony");
        autoClasico.asignarUnaRadio("Aiwa");

        System.out.println("\n***********************************\nLos autos con las nuevas radios\n");
        System.out.println(autoNuevo);
        System.out.println(autoClasico);

        //Asignamos precio a los autos

        autoClasico.setPrecio(2000000.3);
        autoNuevo.setPrecio(3100000);


        System.out.println("\n*************************************\nLos autos tienen precio\n");
        System.out.println(autoNuevo);
        System.out.println(autoClasico);
    }
}
