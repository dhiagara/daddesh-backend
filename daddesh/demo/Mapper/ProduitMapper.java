package daddesh.demo.Mapper;


import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dto.ProduitDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProduitMapper {

    @Autowired
    private ModelMapper mapper ;

    public ProduitDto entityToDto(Produit produit){
        return  mapper.map(produit,ProduitDto.class);
    }
    public List<ProduitDto> listEntityToDto (List <Produit> produitList){
        return  produitList.stream().map(produit->entityToDto(produit)).collect(Collectors.toList());
    }

}
