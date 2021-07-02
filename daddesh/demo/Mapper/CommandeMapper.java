package daddesh.demo.Mapper;

import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.User;
import daddesh.demo.dto.ComandeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CommandeMapper {

    @Autowired
    private ModelMapper mapper ;

    public List <ComandeDto> entityListTODto (List<Commande> commandeListEntity){
        return commandeListEntity.stream()
                .map(commande -> commandeEntityTodto(commande)).collect(Collectors.toList());
    }

    public ComandeDto commandeEntityTodto(Commande commande){
        //map commande from entity to dto
        ComandeDto comandeDto =mapper.map(commande,ComandeDto.class);

        User user =mapper.map(commande.getUser(),User.class);
        comandeDto.setUserId(user.getId());
        return comandeDto;
    }
    public ComandeDto entityToDto(Commande entity){

        return mapper.map(entity,ComandeDto.class);
    }
    public Page<ComandeDto> pageEntityToDto(Page<Commande> pageEntity){
        Page<ComandeDto> comandeDtoPage=pageEntity.map(new Function<Commande, ComandeDto>() {
            @Override
            public ComandeDto apply(Commande commande) {
                return mapper.map(commande,ComandeDto.class);
            }
        });
                return comandeDtoPage;
    }


}
