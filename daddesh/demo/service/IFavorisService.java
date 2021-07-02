package daddesh.demo.service;

import daddesh.demo.dao.entity.Favoris;
import daddesh.demo.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface IFavorisService {
    List<Favoris> getAllFavoris();
    Favoris addFavoris (Favoris favoris);
    boolean updateFavoris (Favoris favoris);
    boolean deleteFavoris (Long id);
    Optional<Favoris> findById(Long id);
    List<Favoris> getByUser(User user);
}
