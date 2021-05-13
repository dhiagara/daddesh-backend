package daddesh.demo.dao.Impl;

import daddesh.demo.dao.IBlogDao;
import daddesh.demo.dao.entity.Blog;
import daddesh.demo.dao.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BlogDaoImpl implements IBlogDao {
    @Autowired
    IBlogRepository iBlogRepository ;
    @Override
    public List<Blog> getAllBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog addBlog(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public boolean updateBlog(Blog blog) {
        if (iBlogRepository.save(blog) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteBlog(Long id) {
        if (iBlogRepository.findById(id) !=null){
            iBlogRepository.deleteById(id);
            return true;}
        else
            return false;
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return iBlogRepository.findById(id);
    }
}
