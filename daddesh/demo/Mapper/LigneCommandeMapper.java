package daddesh.demo.Mapper;

import daddesh.demo.dao.entity.LigneCommande;
import daddesh.demo.dto.AddLigneCommandeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LigneCommandeMapper {

    private final ModelMapper mapper ;

    @Autowired
    public LigneCommandeMapper (ModelMapper mapper){this.mapper=mapper;}


    public List <LigneCommande> listDtoToEntity (List<AddLigneCommandeDto> dtoList){
        return dtoList.stream().map(addLigneCommandeDto -> mapper.map(addLigneCommandeDto,LigneCommande.class))
                .collect(Collectors.toList());
    }
    public List <AddLigneCommandeDto> listEntityToDto (List<LigneCommande> entityList){
        return entityList.stream().map(ligneCommande -> mapper.map(ligneCommande,AddLigneCommandeDto.class))
                .collect(Collectors.toList());
    }

}
