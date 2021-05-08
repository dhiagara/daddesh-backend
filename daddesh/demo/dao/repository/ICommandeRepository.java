package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.Commande;

import daddesh.demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommandeRepository extends JpaRepository<Commande,Long> {
    List<Commande> findByUser(User user);
}
