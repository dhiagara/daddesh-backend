package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IImagesRepository extends JpaRepository<Images,Long> {
    List<Images> findByProduit(Produit produit);
}
