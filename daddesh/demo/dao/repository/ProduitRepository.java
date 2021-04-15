package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
