package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailId(String email);
}
