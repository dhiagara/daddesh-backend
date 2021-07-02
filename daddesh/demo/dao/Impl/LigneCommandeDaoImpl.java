package daddesh.demo.dao.Impl;

import daddesh.demo.dao.ILigneCommandeDao;
import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.LigneCommande;
import daddesh.demo.dao.entity.User;
import daddesh.demo.dao.repository.ICommandeRepository;
import daddesh.demo.dao.repository.ILigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {
    @Autowired
    ILigneCommandeRepository ligneCommandeRepository;
    @Override
    public List<LigneCommande> getAllLigneCommande() {
        return ligneCommandeRepository.findAll();
    }

    @Override
    public LigneCommande addLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Override
    public boolean updateLigneCommande(LigneCommande ligneCommande) {
        if (ligneCommandeRepository.save(ligneCommande) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteLigneCommande(Long id) {
        if (ligneCommandeRepository.findById(id) !=null){
            ligneCommandeRepository.deleteById(id);
            return true;}
        else
            return false;
    }

    @Override
    public Optional<LigneCommande> findById(Long id) {
        return ligneCommandeRepository.findById(id);
    }

   /* @Override
    public List<LigneCommande> getByCommande(Commande commande) {
        return ligneCommandeRepository.findByCommande(commande);
    }*/

    /*@Override
    public List<LigneCommande> findByUser(User user) {
        return null;
    }*/
}
