package daddesh.demo.service.impl;

import daddesh.demo.dao.IBlogCommentDao;
import daddesh.demo.dao.entity.Blog;
import daddesh.demo.dao.entity.BlogComment;
import daddesh.demo.service.IBlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogCommentService implements IBlogCommentService {
    @Autowired
    IBlogCommentDao iBlogCommentDao;

    @Override
    public List<BlogComment> getAllBlogComment() {
        return iBlogCommentDao.getAllBlogComment();
    }

    @Override
    public BlogComment addBlogComment(BlogComment comment) {
        return iBlogCommentDao.addBlogComment(comment);
    }

    @Override
    public boolean updateBlogComment(BlogComment comment) {
        return iBlogCommentDao.updateBlogComment(comment);
    }

    @Override
    public boolean deleteBlogComment(Long id) {
        return iBlogCommentDao.deleteBlogComment(id);
    }

    @Override
    public Optional<BlogComment> findById(Long id) {
        return iBlogCommentDao.findById(id);
    }

    @Override
    public Page<BlogComment> getAllBlogComment(Pageable pageable) {
        return iBlogCommentDao.getAllBlogComment(pageable);
    }

    @Override
    public List<BlogComment> getByBlog(Blog blog) {
        return iBlogCommentDao.getByBlog(blog);
    }
}
