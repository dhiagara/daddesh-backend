package daddesh.demo.service.impl;

import daddesh.demo.dao.IActualiteDao;
import daddesh.demo.dao.entity.Actualite;
import daddesh.demo.service.IActualiteService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ActualiteServiceImpl implements IActualiteService {
    @Autowired
    IActualiteDao iActualiteDao;
    @Autowired
    ServletContext context;

    @Override
    public List<Actualite> getAllActualite() {
        return iActualiteDao.getAllActualite();
    }

    @Override
    public Actualite addActualite(Actualite actualite, MultipartFile file) {
        String fileName = fileuploadImage(file) ;
        actualite.setImage(fileName);
        return iActualiteDao.addActualite(actualite);
    }

    @Override
    public byte[] getActualiteImage(Long id)throws Exception {

        Actualite ac =  iActualiteDao.findById(id) .orElse(null);

        return Files.readAllBytes(Paths.get(context.getRealPath("/ActualiteImages/")+ac.getImage()));
    }


    @Override
    public boolean updateActualite(Actualite actualite,MultipartFile file) {
        String fileName = fileuploadImage(file) ;
        actualite.setImage(fileName);
        return iActualiteDao.updateActualite(actualite);
    }

    @Override
    public boolean deleteActualite(Long id) {
        return iActualiteDao.deleteActualite(id);
    }

    @Override
    public Optional<Actualite> findById(Long id) {
        return iActualiteDao.findById(id);
    }


    String fileuploadImage(MultipartFile file) {
        System.out.println("dodo2"+file);
        boolean isExit = new File(context.getRealPath("/BlogImages/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/ActualiteImages/")).mkdir();
            System.out.println("mk dir.............");
        }


        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/ActualiteImages/"+File.separator+newFileName));
        try
        {

            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
        return filename;

    }
}
