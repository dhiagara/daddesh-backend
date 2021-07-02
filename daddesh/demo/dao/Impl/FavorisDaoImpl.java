package daddesh.demo.dao.Impl;

import daddesh.demo.dao.IFavorisDao;
import daddesh.demo.dao.entity.Favoris;
import daddesh.demo.dao.entity.User;
import daddesh.demo.dao.repository.IFavorisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FavorisDaoImpl implements IFavorisDao {
@Autowired
    IFavorisRepository iFavorisRepository;
    @Override
    public List<Favoris> getAllFavoris() {
        return iFavorisRepository.findAll();
    }

    @Override
    public Favoris addFavoris(Favoris favoris) {
        return iFavorisRepository.save(favoris);
    }

    @Override
    public boolean updateFavoris(Favoris favoris) {
        if (iFavorisRepository.save(favoris) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteFavoris(Long id) {
        if (iFavorisRepository.findById(id) !=null){
            iFavorisRepository.deleteById(id);
            return true;}
        else
            return false;
    }

    @Override
    public Optional<Favoris> findById(Long id) {
        return iFavorisRepository.findById(id);
    }

    @Override
    public List<Favoris> getByUser(User user) {
        return iFavorisRepository.findByUser(user);
    }
}
