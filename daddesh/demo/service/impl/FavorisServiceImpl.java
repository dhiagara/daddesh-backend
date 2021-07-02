package daddesh.demo.service.impl;

import daddesh.demo.dao.IFavorisDao;
import daddesh.demo.dao.Impl.FavorisDaoImpl;
import daddesh.demo.dao.entity.Favoris;
import daddesh.demo.dao.entity.User;
import daddesh.demo.service.IFavorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavorisServiceImpl implements IFavorisService {
    @Autowired
    IFavorisDao favorisDao;
    @Override
    public List<Favoris> getAllFavoris() {
        return favorisDao.getAllFavoris();
    }

    @Override
    public Favoris addFavoris(Favoris favoris) {
        return favorisDao.addFavoris(favoris);
    }

    @Override
    public boolean updateFavoris(Favoris favoris) {
        return favorisDao.updateFavoris(favoris);
    }

    @Override
    public boolean deleteFavoris(Long id) {
        return favorisDao.deleteFavoris(id);
    }

    @Override
    public Optional<Favoris> findById(Long id) {
        return favorisDao.findById(id);
    }

    @Override
    public List<Favoris> getByUser(User user) {
        return favorisDao.getByUser(user);
    }
}
