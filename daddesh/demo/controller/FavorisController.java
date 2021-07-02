package daddesh.demo.controller;

import daddesh.demo.dao.entity.Favoris;
import daddesh.demo.dao.entity.User;
import daddesh.demo.service.IFavorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/favoris")
public class FavorisController {

    @Autowired
    IFavorisService favorisService;
    @GetMapping("/")
    public List<Favoris> getFavoris(){
        return  favorisService.getAllFavoris();

    }
    @GetMapping("/find")
    public Optional<Favoris> getFavoris(@RequestParam Long id){
        return  favorisService.findById(id);

    }
    @PostMapping("/add")
    public Favoris addCommande(@RequestBody Favoris favoris){
        System.out.println(favoris);
        return  favorisService.addFavoris(favoris);

    }
    @DeleteMapping("/remove")
    public boolean deleteFavoris(@RequestParam Long id){
        return  favorisService.deleteFavoris(id);

    }
    @PutMapping ("/update")
    public boolean updateFavoris(@RequestBody Favoris favoris){
        return  favorisService.updateFavoris(favoris);

    }
    @GetMapping("/findbyUser")
    public List <Favoris> getFavorisByUser(@RequestParam User user){
        return  favorisService.getByUser(user);

    }

}
