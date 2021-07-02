package daddesh.demo.service.impl;

import daddesh.demo.Mapper.ProduitMapper;
import daddesh.demo.dao.IProduitDao;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dto.ProduitDto;
import daddesh.demo.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements IProduitService {
    @Autowired
    IProduitDao iProduitDao ;
    @Autowired
    ProduitMapper produitMapper;
    @Override
    public List<ProduitDto> getAllProduits() {
return produitMapper.listEntityToDto(iProduitDao.getAllProduits());

    }

    @Override
    public Produit add(Produit produit) {
        return iProduitDao.addProduit(produit);
    }

    @Override
    public boolean update(Produit produit) {
        return iProduitDao.updateProduit(produit);
    }

    @Override
    public boolean deleteById(Long id) {
        return iProduitDao.deleteProduit(id);
    }

    @Override
    public Produit findById(Long id) {
        Optional<Produit> clintOptional= iProduitDao.findById(id);
        return  clintOptional.orElseThrow(()-> new EntityNotFoundException("Produit Not found with id "+ id));

    }

    @Override
    public Page<Produit> getAllProduits(Pageable pageable) {
        return iProduitDao.getAllProduits(pageable);
    }
}
