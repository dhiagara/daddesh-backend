package daddesh.demo.service;

import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.User;
import daddesh.demo.dto.ComandeDto;
import daddesh.demo.dto.CommandeAddDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IComandeService {
    List<ComandeDto> getAllCommande();
    ComandeDto addCommande (CommandeAddDto commandeAddDto);
    boolean updateCommande (ComandeDto commandeDto);
    boolean deleteCommande (Long id);
    ComandeDto findById(Long id);

    List<ComandeDto> getByUser(User user);

    Page<ComandeDto> getAll(Pageable pageable);

}
