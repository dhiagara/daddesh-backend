package daddesh.demo.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daddesh.demo.dao.IUserDao;
import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dao.entity.User;
import daddesh.demo.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService ,UserDetailsService{
    @Autowired
    ServletContext context;
    @Autowired
    IUserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    @Override
    public User addUser(User user , MultipartFile file) {


       String fileName = fileuploadImage(file) ;
       System.out.println("dodo"+fileName);
        User newUser = new User();
        user.setRole("ROLE_USER");
        if(user.getEmailId().equals("admin")){
            user.setRole("ROLE_ADMIN");
        }
        newUser.setImage(fileName);
        newUser.setEmailId(user.getEmailId());
        newUser.setAdresse(user.getAdresse());
        newUser.setTelephone(user.getTelephone());
        newUser.setNom(user.getNom());
        newUser.setPrenom(user.getPrenom());
        newUser.setCodePostal(user.getCodePostal());

        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return userDao.addUser(newUser);

    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User findById(Long id) {

        Optional<User> clintOptional= userDao.findById(id);
        return  clintOptional.orElseThrow(()-> new EntityNotFoundException("User Not found with id "+ id));

    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userDao.getAllUsers(pageable);
    }

    @Override
    public UserDetails findByEmail(String email) throws UsernameNotFoundException  {
        List<SimpleGrantedAuthority> roles = null;


        User user = userDao.findByEmail(email);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User not found with the name " +email);
    }

    @Override
    public User findByEmaill(String email) {
        return  userDao.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;


        User user = userDao.findByEmail(email);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User not found with the name " +email);
    }


    String fileuploadImage(MultipartFile file) {
        System.out.println("dodo2"+file);
      boolean isExit = new File(context.getRealPath("/UserImages/")).exists();
      if (!isExit)
      {
          new File (context.getRealPath("/UserImages/")).mkdir();
          System.out.println("mk dir.............");
      }


          String filename = file.getOriginalFilename();
          String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
          File serverFile = new File (context.getRealPath("/UserImages/"+File.separator+newFileName));
          try
          {

              FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

          }catch(Exception e) {
              e.printStackTrace();
          }
          return filename;

  }
}
