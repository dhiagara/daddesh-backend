package daddesh.demo.controller;

import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dao.entity.User;
import daddesh.demo.service.IComandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/commande")

public class CommandeController {
    @Autowired
    IComandeService comandeService;
    @GetMapping("/")
    public List<Commande> getCommande(){
        return  comandeService.getAllCommande();

    }
    @GetMapping("/find")
    public Optional<Commande> getCommande(@RequestParam Long id){
        return  comandeService.findById(id);

    }
    @PostMapping("/add")
    public Commande addCommande(@RequestBody Commande commande){
        System.out.println(commande);
        return  comandeService.addCommande(commande);

    }
    @DeleteMapping("/remove")
    public boolean deleteCommande(@RequestParam Long id){
        return  comandeService.deleteCommande(id);

    }
    @PutMapping ("/update")
    public boolean updateCommande(@RequestBody Commande Commande){
        return  comandeService.updateCommande(Commande);

    }
    @GetMapping("/findbyUser")
    public List <Commande> getCommandeByUser(@RequestParam User user){
        return  comandeService.getByUser(user);

    }

}
