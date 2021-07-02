package daddesh.demo.dao;

import daddesh.demo.dao.entity.Commande;


import daddesh.demo.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICommandeDao {
    List<Commande> getAllCommande();
    Commande addCommande (Commande commande);
    boolean updateCommande (Commande commande);
    boolean deleteCommande (Long id);
    Optional<Commande> findById(Long id);
    List<Commande> getByUser(User user);
    Page <Commande> getAll(Pageable pageable);
}
