package daddesh.demo.service;

import daddesh.demo.dao.entity.Actualite;
import daddesh.demo.dao.entity.Blog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IActualiteService {
    List<Actualite> getAllActualite();
    Actualite addActualite (Actualite actualite,MultipartFile file);
    boolean updateActualite (Actualite actualite,MultipartFile file);
    boolean deleteActualite (Long id);
    Optional<Actualite> findById(Long id);

    public byte[] getActualiteImage(Long id) throws Exception;

}
