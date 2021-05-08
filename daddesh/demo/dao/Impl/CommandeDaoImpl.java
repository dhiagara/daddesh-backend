package daddesh.demo.dao.Impl;

import daddesh.demo.dao.ICommandeDao;
import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.User;
import daddesh.demo.dao.repository.ICommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CommandeDaoImpl implements ICommandeDao {
    @Autowired
    ICommandeRepository commandeRepository;

    @Override
    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public boolean updateCommande(Commande commande) {
        if (commandeRepository.save(commande) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteCommande(Long id) {
        if (commandeRepository.findById(id) !=null){
            commandeRepository.deleteById(id);
            return true;}
        else
            return false;
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeRepository.findById(id);
    }

    @Override
    public List<Commande> getByUser(User user) {
        return commandeRepository.findByUser(user);
    }
}
