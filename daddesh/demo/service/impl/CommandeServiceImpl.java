package daddesh.demo.service.impl;

import daddesh.demo.Mapper.CommandeMapper;
import daddesh.demo.Mapper.LigneCommandeMapper;
import daddesh.demo.dao.ICommandeDao;
import daddesh.demo.dao.IProduitDao;
import daddesh.demo.dao.IUserDao;
import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.LigneCommande;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dao.entity.User;
import daddesh.demo.dto.ComandeDto;
import daddesh.demo.dto.CommandeAddDto;
import daddesh.demo.service.IComandeService;
import daddesh.demo.service.IProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements IComandeService {

    private final IProduitDao iProduitDao ;
    private final LigneCommandeMapper ligneCommandeMapper;

    @Autowired
    ModelMapper mapper ;
    @Autowired
    CommandeMapper commandeMapper ;
    @Autowired
    ICommandeDao commandeDao ;
    @Autowired
    IUserDao userDao ;

    @Autowired
    CommandeServiceImpl(IProduitDao iProduitDao,LigneCommandeMapper ligneCommandeMapper){
        this.iProduitDao =iProduitDao;
        this.ligneCommandeMapper=ligneCommandeMapper;
    }

    @Override
    public List<ComandeDto> getAllCommande() {
        return commandeMapper.entityListTODto(commandeDao.getAllCommande());
    }

    @Override
    @Transactional
    public ComandeDto addCommande(CommandeAddDto commandeAddDto) {
        Optional<User> userEntity = userDao.findById(commandeAddDto.getUserId());
        if(userEntity.isPresent()){
            Commande commandeEntity=mapper.map(commandeAddDto,Commande.class);
            commandeEntity.setUser(userEntity.get());
            commandeEntity.setLigneCommandes(
                    ligneCommandeMapper.listDtoToEntity(commandeAddDto.getLigneCommande())
            );
            //setProduit
            for (LigneCommande ligneCommande :commandeEntity.getLigneCommandes()){
                Produit produit=iProduitDao.findById(ligneCommande.getProduit().getId()).orElseThrow(null);
                if(produit!=null){
                    ligneCommande.setProduit(produit);
                    ligneCommande.setCommande(commandeEntity);
                }else  return null;

            }
            Commande commandeEntityWithId=commandeDao.addCommande(commandeEntity);
            ComandeDto comandeDto =mapper.map(commandeEntityWithId,ComandeDto.class);
            comandeDto.setUserId(mapper.map(commandeEntityWithId.getUser(),User.class).getId());
            return comandeDto;

        }
        return null;

    }

    @Override
    public boolean updateCommande(ComandeDto commandedto) {
        Optional<User> user=userDao.findById(commandedto.getUserId());
        Commande commandeEntity = commandeDao.findById(commandedto.getId()).orElse(null);
        if(commandeEntity!=null && user.isPresent()){
            Commande commandeMapEntity=mapper.map(commandedto,Commande.class);
            commandeMapEntity.setUser(user.get());
            return commandeDao.updateCommande(commandeMapEntity);

        }
        return  false ;
    }

    @Override
    public boolean deleteCommande(Long id) {
        return commandeDao.deleteCommande(id);
    }

    @Override
    public ComandeDto findById(Long id) {
        return mapper.map(commandeDao.findById(id),ComandeDto.class);
    }

    @Override
    public List<ComandeDto> getByUser(User user) {
       List<Commande> commandes=commandeDao.getByUser(user);
       return commandeMapper.entityListTODto(commandes);
    }

    @Override
    public Page<ComandeDto> getAll(Pageable pageable) {
        return null;
    }
}
