package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
}
