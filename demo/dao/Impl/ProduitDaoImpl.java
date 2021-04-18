package daddesh.demo.dao.Impl;

import daddesh.demo.dao.IProduitDao;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dao.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProduitDaoImpl implements IProduitDao {
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public boolean updateProduit(Produit produit) {
        if (produitRepository.save(produit) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteProduit(Long id) {
        if (produitRepository.existsById(id)){
            produitRepository.deleteById(id);
            return true;
        }
        return false;
    }



    @Override
    public Optional<Produit> findById(Long id) {
        return produitRepository.findById(id);
    }
    @Override
    public Page<Produit> getAllProduits(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }
}
