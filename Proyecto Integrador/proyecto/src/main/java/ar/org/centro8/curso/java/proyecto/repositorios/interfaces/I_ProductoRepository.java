package ar.org.centro8.curso.java.proyecto.repositorios.interfaces;

import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.Producto;

public interface I_ProductoRepository {
    void save(Producto producto);
    void remove(Producto producto);
    void update(Producto producto);

    List<Producto>getAll();
    
    default Producto getById(int id){
        return getAll()
                .stream()
                .filter(c->c.getId() == id)
                .findFirst()
                .orElse(new Producto());
    };
    default List<Producto>getLikeNombre(String nombre){
        if (nombre == null){
            return new ArrayList<>();
        }
        return getAll()
                        .stream()
                        .filter(c -> c.getNombre() != null && c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                        .toList();    
    };

    default List<Producto>getLikeMarca(String marca){
        if (marca == null){
            return new ArrayList<>();
        }
        return getAll()
                        .stream()
                        .filter(c -> c.getMarca() != null && c.getMarca().toLowerCase().contains(marca.toLowerCase()))
                        .toList();    
    };
}
