package ar.org.centro8.curso.java.proyecto.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.proyecto.entities.Colegio;
import ar.org.centro8.curso.java.proyecto.repositorios.interfaces.I_ColegioRepository;

public class ColegioRepository implements I_ColegioRepository {
    private Connection conn;
    
    public ColegioRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Colegio colegio) {
        if (colegio == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
            "insert into colegios(nombre, direccion) values (?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS);) {
                ps.setString(1, colegio.getNombre());
                ps.setString(2,colegio.getDireccion());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                    colegio.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Colegio colegio) {
        if (colegio == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement("delete from colegios where id = ?")) {
            ps.setInt(1, colegio.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Colegio colegio) {
        if (colegio == null){
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(
                "update colegios set nombre = ?, direccion = ? where id = ?")) {
                ps.setString(1, colegio.getNombre());
                ps.setString(2, colegio.getDireccion());
                ps.setInt(3, colegio.getId());
                ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Colegio> getAll() {
        List<Colegio> list = new ArrayList<>();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from colegios")){
            while(rs.next()){
                list.add(
                    new Colegio(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("direccion")
                    )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
