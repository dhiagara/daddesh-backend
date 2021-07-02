package daddesh.demo.dao.Impl;

import daddesh.demo.dao.IActualiteDao;
import daddesh.demo.dao.entity.Actualite;
import daddesh.demo.dao.repository.IActualiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActualiteDaoImpl implements IActualiteDao {

    @Autowired
    IActualiteRepository iActualiteRepository ;

    @Override
    public List<Actualite> getAllActualite() {
        return iActualiteRepository.findAll();
    }

    @Override
    public Actualite addActualite(Actualite actualite) {
        return iActualiteRepository.save(actualite);
    }

    @Override
    public boolean updateActualite(Actualite actualite) {
        if (iActualiteRepository.save(actualite) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteActualite(Long id) {
        if (iActualiteRepository.findById(id) !=null){
            iActualiteRepository.deleteById(id);
            return true;}
        else
            return false;
    }


    @Override
    public Optional<Actualite> findById(Long id) {
        return  iActualiteRepository.findById(id);
    }
}
