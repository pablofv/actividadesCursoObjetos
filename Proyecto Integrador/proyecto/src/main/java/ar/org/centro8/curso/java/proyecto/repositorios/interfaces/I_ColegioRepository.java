package ar.org.centro8.curso.java.proyecto.repositorios.interfaces;

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
                .filter(a->a.getId() == id)
                .findFirst()
                .orElse(new Colegio());
    };
}
