package daddesh.demo.service;

import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dto.ProduitDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProduitService {
    List<ProduitDto> getAllProduits();
    Produit add (Produit produit);
    boolean update (Produit produit);
    boolean deleteById (Long id);
    Produit findById(Long id);
    Page<Produit> getAllProduits(Pageable pageable);
}
