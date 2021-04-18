package daddesh.demo.controller;


import daddesh.demo.dao.entity.User;
import daddesh.demo.service.impl.RegisterserviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController  {
    @Autowired
    private RegisterserviceImp service;
    @PostMapping("/register")
    public User registerUser (@RequestBody User user) throws Exception{
        String tempEmailId =user.getEmailId();
        if (tempEmailId !=null && !"".equals(tempEmailId))
        {
          User userobj = service.fetchUserByEmailId(tempEmailId);
           if (userobj != null){
               throw new Exception("user with " +tempEmailId+"is already exist");
           }
         }
        User userObj =null;
        userObj= service.saveUser(user);
        return userObj;
        }
      @PostMapping("login")
        public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailID = user.getEmailId();
        String tempPass = user.getPassword();
        User userObj = null;
        if (tempEmailID != null && tempPass  != null){
             userObj  =    service.fetchUserByEmailIdAndPassword(tempEmailID,tempPass);

        }
        if (userObj ==null){
            throw  new Exception("bad credentials");
        }
        return userObj;
}
}
