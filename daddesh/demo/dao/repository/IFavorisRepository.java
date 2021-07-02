package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.Favoris;
import daddesh.demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavorisRepository extends JpaRepository<Favoris,Long> {
    List<Favoris> findByUser(User user);
}
