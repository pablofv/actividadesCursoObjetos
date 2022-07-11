package ar.org.centro8.curso.java.proyecto.repositorios.interfaces;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.Factura;

public interface I_FacturaRepository {
    void save(Factura factura);
    void remove(Factura factura);
    void update(Factura factura);

    List<Factura>getAll();

    default Factura getById(int id){
        return getAll()
                .stream()
                .filter(f->f.getId() == id)
                .findFirst()
                .orElse(new Factura());
    }

    default List<Factura> getByIdColegio(int id){
        return getAll()
                    .stream()
                    .filter(f->f.getIdColegio() == id)
                    .toList();
    }

    default List<Factura> getByFecha(LocalDateTime fecha){
        return getAll()
                    .stream()
                    .filter(f -> f.getFechaFactura() != null && f.getFechaFactura() == fecha)
                    .toList();
    }
}
