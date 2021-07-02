package daddesh.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daddesh.demo.dao.entity.Actualite;
import daddesh.demo.dao.entity.Blog;
import daddesh.demo.service.IActualiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actualite")
public class ActualiteController {
    @Autowired
    IActualiteService iActualiteService;
    @Autowired


    @GetMapping("/")
    public List<Actualite> getActualite(){
        return  iActualiteService.getAllActualite();

    }
    @GetMapping("/find")
    public Optional<Actualite> getActualite(@RequestParam Long id){
        return  iActualiteService.findById(id);

    }
    @PostMapping("/add")
    public ResponseEntity<?> saveActualite(@RequestParam("file[]") MultipartFile file,
                                      @RequestParam("actualite") String actualite)
            throws JsonParseException, JsonMappingException, Exception{
        Actualite actualite1 = new ObjectMapper().readValue(actualite, Actualite.class);
        return ResponseEntity.ok(iActualiteService.addActualite(actualite1, file));
    }

    @GetMapping(path="/actualiteImage/{id}")
    public byte[] getImageActualite(@PathVariable("id") Long id)throws Exception{

        return iActualiteService.getActualiteImage(id);

    }
    @DeleteMapping("/remove")
    public boolean deleteActualite(@RequestParam Long id){
        return  iActualiteService.deleteActualite(id);

    }
    @PutMapping ("/update")
    public ResponseEntity<?> updateActualite(@RequestParam("file[]") MultipartFile file,
                                           @RequestParam("actualite") String actualite)
            throws JsonParseException, JsonMappingException, Exception{
        System.out.println("actttttttttttttttttttttttttttttttttttttt"+actualite);
        Actualite actualite1 = new ObjectMapper().readValue(actualite, Actualite.class);
        return ResponseEntity.ok(iActualiteService.updateActualite(actualite1, file));
    }

}
