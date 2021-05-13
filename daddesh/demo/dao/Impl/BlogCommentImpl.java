package daddesh.demo.dao.Impl;

import daddesh.demo.dao.IBlogCommentDao;
import daddesh.demo.dao.entity.Blog;
import daddesh.demo.dao.entity.BlogComment;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dao.repository.IBlogCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BlogCommentImpl implements IBlogCommentDao {
    @Autowired
    IBlogCommentRepository iBlogCommentRepository ;

    @Override
    public List<BlogComment> getAllBlogComment() {
        return iBlogCommentRepository.findAll();
    }

    @Override
    public BlogComment addBlogComment(BlogComment comment) {
        return iBlogCommentRepository.save(comment);
    }

    @Override
    public boolean updateBlogComment(BlogComment comment) {

        if (iBlogCommentRepository.save(comment) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteBlogComment(Long id) {

        if (iBlogCommentRepository.findById(id) !=null){
            iBlogCommentRepository.deleteById(id);
            return true;}
        else
            return false;
    }

    @Override
    public Optional<BlogComment> findById(Long id) {
        return iBlogCommentRepository.findById(id);
    }

    @Override
    public Page<BlogComment> getAllBlogComment(Pageable pageable) {
        return iBlogCommentRepository.findAll(pageable);
    }

    @Override
    public List<BlogComment> getByBlog(Blog blog) {
        return iBlogCommentRepository.findBlogCommentByBlog(blog);
    }
}
