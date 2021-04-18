package daddesh.demo.controller;


import daddesh.demo.dao.entity.Produit;
import daddesh.demo.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/produit")
@CrossOrigin
public class ProduitController {
    @Autowired
    private IProduitService produitService;

    @GetMapping("/")
    public List<Produit> getProduits(){
        return  produitService.getAllProduits();

    }
    @GetMapping("/find")
    public Produit getProduit(@RequestParam Long id){
        return  produitService.findById(id);

    }
    @PostMapping("/add")
    public Produit addProduit(@RequestBody Produit Produit){
        return  produitService.add(Produit);

    }
    @DeleteMapping("/remove")
    public boolean deleteProduit(@RequestParam Long id){
        return  produitService.deleteById(id);

    }
    @PutMapping ("/update")
    public boolean updateProduit(@RequestBody Produit Produit){
        return  produitService.update(Produit);

    }

}
