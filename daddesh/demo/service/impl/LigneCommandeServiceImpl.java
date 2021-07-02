package daddesh.demo.service.impl;

import daddesh.demo.dao.ILigneCommandeDao;
import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.LigneCommande;
import daddesh.demo.dao.entity.User;
import daddesh.demo.service.ILigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeServiceImpl implements ILigneCommandeService {
    @Autowired
    ILigneCommandeDao ligneCommandeDao ;

    @Override
    public List<LigneCommande> getAllLigneCommande() {
        return ligneCommandeDao.getAllLigneCommande() ;
    }

    @Override
    public LigneCommande addLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeDao.addLigneCommande(ligneCommande);
    }

    @Override
    public boolean updateLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeDao.updateLigneCommande(ligneCommande);
    }

    @Override
    public boolean deleteLigneCommande(Long id) {
        return ligneCommandeDao.deleteLigneCommande(id);
    }

    @Override
    public Optional<LigneCommande> findById(Long id) {
        return ligneCommandeDao.findById(id);
    }

  /*  @Override
    public List<LigneCommande> getByCommande(Commande commande) {
        return ligneCommandeDao.getByCommande(commande);
    }*/

   /* @Override
    public List<LigneCommande> findByUser(User user) {
        return null;
    }*/
}
