package ar.org.centro8.curso.java.proyecto.repositorios.interfaces;

import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.Colegio;

public interface I_ColegioRepository {
    void save(Colegio colegio);
    void remove(Colegio colegio);
    void update(Colegio colegio);

    List<Colegio>getAll();
    
    default Colegio getById(int id){
        return getAll()
                .stream()
                .filter(c->c.getId() == id)
                .findFirst()
                .orElse(new Colegio());
    };
    default List<Colegio>getLikeNombre(String nombre){
        if (nombre == null){
            return new ArrayList<>();
        }
        return getAll()
                        .stream()
                        .filter(c -> c.getNombre() != null && c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                        .toList();    
    };

    default List<Colegio>getLikeDireccion(String direccion){
        if (direccion == null){
            return new ArrayList<>();
        }
        return getAll()
                        .stream()
                        .filter(c -> c.getDireccion() != null && c.getDireccion().toLowerCase().contains(direccion.toLowerCase()))
                        .toList();    
    };
}
