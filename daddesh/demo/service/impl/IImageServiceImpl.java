package daddesh.demo.service.impl;

import daddesh.demo.dao.IImagesDao;
import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IImageServiceImpl implements IImageService {
    @Autowired
    IImagesDao iImagesDao ;

    @Override
    public List<Images> getAllImages() {
        return iImagesDao.getAllImages();
    }

    @Override
    public Images addImages(Images images) {
        return iImagesDao.addImages(images);
    }

    @Override
    public boolean updateImages(Images images) {
        return iImagesDao.updateImages(images);
    }

    @Override
    public boolean deleteImages(Long id) {
        return iImagesDao.deleteImages(id);
    }

    @Override
    public Optional<Images> findById(Long id) {
        return iImagesDao.findById(id);
    }

    @Override
    public List<Images> getByProduit(Produit produit) {
        return iImagesDao.getByProduit(produit);
    }
}
