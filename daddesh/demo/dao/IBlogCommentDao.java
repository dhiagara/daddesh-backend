package daddesh.demo.dao;

import daddesh.demo.dao.entity.Blog;
import daddesh.demo.dao.entity.BlogComment;
import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogCommentDao {
    List<BlogComment> getAllBlogComment();
    BlogComment addBlogComment (BlogComment comment);
    boolean updateBlogComment (BlogComment comment);
    boolean deleteBlogComment (Long id);
    Optional<BlogComment> findById(Long id);
    Page<BlogComment> getAllBlogComment(Pageable pageable);
    List<BlogComment> getByBlog(Blog blog);

}
