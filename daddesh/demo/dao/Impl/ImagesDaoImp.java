package daddesh.demo.dao.Impl;

import daddesh.demo.dao.IImagesDao;
import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dao.repository.IImagesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ImagesDaoImp implements IImagesDao {
    @Autowired
    private IImagesRepository iImagesRepository;
    @Override
    public List<Images> getAllImages() {
        return iImagesRepository.findAll();
    }

    @Override
    public Images addImages(Images images) {
        return iImagesRepository.save(images);
    }

    @Override
    public boolean updateImages(Images images) {
        if (iImagesRepository.save(images) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteImages(Long id) {
        if (iImagesRepository.existsById(id)) {
            iImagesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Images> findById(Long id) {
        return iImagesRepository.findById(id);
    }

    @Override
    public List<Images> getByProduit(Produit produit) {
       return iImagesRepository.findByProduit(produit);
    }
}
