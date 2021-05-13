package daddesh.demo.service.impl;

import daddesh.demo.dao.IBlogDao;
import daddesh.demo.dao.entity.Blog;
import daddesh.demo.service.IBlogService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;


@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogDao iBlogDao;
    @Autowired
    ServletContext context;
    @Override
    public List<Blog> getAllBlog() {
        return iBlogDao.getAllBlog();
    }

    @Override
    public Blog addBlog(Blog blog, MultipartFile file) {

        String fileName = fileuploadImage(file) ;
        blog.setImage(fileName);
        Date currentSqlDate = new Date(System.currentTimeMillis());
        blog.setDate(currentSqlDate);
       
        return iBlogDao.addBlog(blog);
    }

    @Override
    public byte[] getBlogImage(Long id)throws Exception {

       Blog b =  iBlogDao.findById(id) .orElse(null);

        return Files.readAllBytes(Paths.get(context.getRealPath("/BlogImages/")+b.getImage()));
    }




    @Override
    public boolean updateBlog(Blog blog) {
        return iBlogDao.updateBlog(blog);
    }

    @Override
    public boolean deleteBlog(Long id) {
        return iBlogDao.deleteBlog(id);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogDao.findById(id) .orElse(null);
    }


    String fileuploadImage(MultipartFile file) {
        System.out.println("dodo2"+file);
        boolean isExit = new File(context.getRealPath("/BlogImages/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/BlogImages/")).mkdir();
            System.out.println("mk dir.............");
        }


        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/BlogImages/"+File.separator+newFileName));
        try
        {

            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
        return filename;

    }
}
