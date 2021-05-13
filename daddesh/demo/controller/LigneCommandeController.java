package daddesh.demo.controller;

import daddesh.demo.dao.entity.Commande;
import daddesh.demo.dao.entity.LigneCommande;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dao.entity.User;
import daddesh.demo.service.IComandeService;
import daddesh.demo.service.ILigneCommandeService;
import daddesh.demo.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lignecommande")
public class LigneCommandeController {
    @Autowired
    ILigneCommandeService ligneCommandeService;
    @Autowired
    IComandeService comandeService ;
    @GetMapping("/")
    public List<LigneCommande> getLigneCommande(){
        return  ligneCommandeService.getAllLigneCommande();

    }
    @GetMapping("/find")
    public Optional<LigneCommande> getLigneCommande(@RequestParam Long id){
        return  ligneCommandeService.findById(id);

    }
    @PostMapping("/add")
    public Boolean addLigneCommande(@RequestBody User user
                                          ){

    List<Commande> cds =comandeService.getByUser(user);

        for (Commande commande:cds
             ) {
            System.out.println(commande);
            commande.setStatus(true);
            comandeService.updateCommande(commande);
        }
//System.out.println("ligneCommande information"+ligneCommande);

     //   return  ligneCommandeService.addLigneCommande(ligneCommande);
        return true ;

    }
    @DeleteMapping("/remove")
    public boolean deleteLigneCommande(@RequestParam Long id){
        return  ligneCommandeService.deleteLigneCommande(id);

    }
    @PutMapping ("/update")
    public boolean updateLigneCommande(@RequestBody LigneCommande ligneCommande){
        return  ligneCommandeService.updateLigneCommande(ligneCommande);

    }
    @GetMapping("/findbyCommande")
    public List <LigneCommande> getLigneCommandeByCommande(@RequestParam Commande commande){
        return  ligneCommandeService.getByCommande(commande);

    }

    @GetMapping("/findbyUser")
    public List <LigneCommande> getCommandeByUser(@RequestParam User user){
        return  ligneCommandeService.findByUser(user);

    }
}
