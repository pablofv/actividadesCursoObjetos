package ar.org.centro8.curso.java.proyecto.repositorios.interfaces;

import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.ItemFactura;

public interface I_ItemFacturaRepository {
    void save(ItemFactura itemFactura);
    void remove(ItemFactura itemFactura);
    void update(ItemFactura itemFactura);

    List<ItemFactura>getAll();

    default ItemFactura getById(int id){
        return getAll()
                .stream()
                .filter(ifa->ifa.getId() == id)
                .findFirst()
                .orElse(new ItemFactura());
    }

    default List<ItemFactura> getByIdFactura(int id){
        return getAll()
                    .stream()
                    .filter(ifa->ifa.getIdFactura() == id)
                    .toList();
    }

    default List<ItemFactura> getByIdProducto(int id){
        return getAll()
                    .stream()
                    .filter(ifa->ifa.getIdProducto() == id)
                    .toList();
    }
}
