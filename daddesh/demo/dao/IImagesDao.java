package daddesh.demo.dao;

import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IImagesDao {
    List<Images> getAllImages();
    Images addImages (Images images);
    boolean updateImages (Images images);
    boolean deleteImages (Long id);
    Optional<Images> findById(Long id);
    List<Images> getByProduit(Produit produit);

}
