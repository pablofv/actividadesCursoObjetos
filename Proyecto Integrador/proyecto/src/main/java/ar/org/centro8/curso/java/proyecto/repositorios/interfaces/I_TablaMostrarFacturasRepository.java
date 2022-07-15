/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.org.centro8.curso.java.proyecto.repositorios.interfaces;

import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.TablaMostrarFacturas;

/**
 *
 * @author Legion
 */
public interface I_TablaMostrarFacturasRepository {
    List<TablaMostrarFacturas>getAll(int nroFactura);
}
