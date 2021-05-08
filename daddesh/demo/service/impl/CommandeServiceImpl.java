package daddesh.demo.service.impl;

import daddesh.demo.dao.ICommandeDao;
import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.User;
import daddesh.demo.service.IComandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements IComandeService {
    @Autowired
    ICommandeDao commandeDao ;

    @Override
    public List<Commande> getAllCommande() {
        return commandeDao.getAllCommande();
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeDao.addCommande(commande);
    }

    @Override
    public boolean updateCommande(Commande commande) {
        return commandeDao.updateCommande(commande);
    }

    @Override
    public boolean deleteCommande(Long id) {
        return commandeDao.deleteCommande(id);
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeDao.findById(id);
    }

    @Override
    public List<Commande> getByUser(User user) {
        return commandeDao.getByUser(user);
    }
}
