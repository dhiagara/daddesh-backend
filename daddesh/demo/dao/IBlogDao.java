package daddesh.demo.dao;

import daddesh.demo.dao.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogDao {


    List<Blog> getAllBlog();
    Blog addBlog (Blog blog);
    boolean updateBlog (Blog blog);
    boolean deleteBlog (Long id);
    Optional<Blog> findById(Long id);

}
