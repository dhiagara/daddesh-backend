package daddesh.demo.dao.repository;

import daddesh.demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResgisterRepository extends JpaRepository<User,Integer> {

    public  User findByEmailId (String emailId);
    public  User findByEmailIdAndPassword (String emailId, String password);

}
