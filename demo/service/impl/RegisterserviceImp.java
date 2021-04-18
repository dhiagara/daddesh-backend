package daddesh.demo.service.impl;

import daddesh.demo.dao.entity.User;
import daddesh.demo.dao.repository.ResgisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterserviceImp {
    @Autowired
    private ResgisterRepository repo;

    public User saveUser (User user){
        return repo.save(user);

    }
    public  User fetchUserByEmailId(String email){
        return repo.findByEmailId(email);
    }
    public  User fetchUserByEmailIdAndPassword(String email, String password){
        return repo.findByEmailIdAndPassword(email,password);

    }
}
