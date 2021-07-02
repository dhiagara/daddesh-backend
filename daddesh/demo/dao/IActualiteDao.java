package daddesh.demo.dao;

import daddesh.demo.dao.entity.Actualite;
import java.util.List;
import java.util.Optional;

public interface IActualiteDao {
    List<Actualite> getAllActualite();
    Actualite addActualite (Actualite actualite);
    boolean updateActualite (Actualite actualite);
    boolean deleteActualite (Long id);
    Optional<Actualite> findById(Long id);
}
