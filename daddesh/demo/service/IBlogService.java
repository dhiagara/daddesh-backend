package daddesh.demo.service;

import daddesh.demo.dao.entity.Blog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();
    Blog addBlog (Blog blog, MultipartFile file);
    boolean updateBlog (Blog blog);
    boolean deleteBlog (Long id);
    Blog findById(Long id);
    public byte[] getBlogImage(Long id) throws Exception;
}
