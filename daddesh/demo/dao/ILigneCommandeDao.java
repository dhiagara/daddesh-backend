package daddesh.demo.dao;

import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.LigneCommande;
import daddesh.demo.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface ILigneCommandeDao {
    List<LigneCommande> getAllLigneCommande();
    LigneCommande addLigneCommande (LigneCommande ligneCommande);
    boolean updateLigneCommande (LigneCommande ligneCommande);
    boolean deleteLigneCommande (Long id);
    Optional<LigneCommande> findById(Long id);
    List<LigneCommande> getByCommande(Commande commande);
    List<LigneCommande> findByUser(User user);

}
