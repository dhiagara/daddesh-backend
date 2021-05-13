package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.LigneCommande;
import daddesh.demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILigneCommandeRepository extends JpaRepository<LigneCommande,Long> {

    List<LigneCommande> findByCommande(Commande commande);
    List<LigneCommande> findByUser(User user);

}
