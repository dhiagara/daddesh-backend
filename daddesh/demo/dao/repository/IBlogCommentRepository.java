package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.Blog;
import daddesh.demo.dao.entity.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogCommentRepository extends JpaRepository<BlogComment,Long> {
    List <BlogComment> findBlogCommentByBlog(Blog blog) ;

}
