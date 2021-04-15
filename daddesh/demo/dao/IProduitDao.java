package daddesh.demo.dao;

import daddesh.demo.dao.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProduitDao {
    List<Produit> getAllProduits();
    Produit addProduit (Produit produit);
    boolean updateProduit (Produit produit);
    boolean deleteProduit (Long id);
    Optional<Produit> findById(Long id);
    Page<Produit> getAllProduits(Pageable pageable);
}
