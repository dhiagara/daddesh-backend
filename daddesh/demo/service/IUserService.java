package daddesh.demo.service;

import daddesh.demo.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    List<User> getAllUsers();
    User addUser (User user , MultipartFile file);
    boolean updateUser (User user);
    boolean deleteUser (Long id);
    User findById(Long id);
    Page<User> getAllUsers(Pageable pageable);
    UserDetails findByEmail(String email);
    User findByEmaill(String email);
}
