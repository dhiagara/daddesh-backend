package daddesh.demo.service;

import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;

import java.util.List;
import java.util.Optional;

public interface IImageService {
    List<Images> getAllImages();
    Images addImages (Images images);
    boolean updateImages (Images images);
    boolean deleteImages (Long id);
    Optional<Images> findById(Long id);
    List<Images> getByProduit(Produit produit);

}
