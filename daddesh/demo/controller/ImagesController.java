package daddesh.demo.controller;

import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Images")
public class ImagesController {
    @Autowired
    private IImageService iImageService;

    @GetMapping("/")
    public List<Images> getImages(){
        return  iImageService.getAllImages();

    }
    @GetMapping("/find")
    public Optional<Images> getImages(@RequestParam Long id){
        return  iImageService.findById(id);

    }
    @PostMapping("/add")
    public Images addImages(@RequestBody Images images){
        return  iImageService.addImages(images);

    }
    @DeleteMapping("/remove")
    public boolean deleteImages(@RequestParam Long id){
        return  iImageService.deleteImages(id);

    }
    @PutMapping ("/update")
    public boolean updateImages(@RequestBody Images images){
        return  iImageService.updateImages(images);

    }
    @GetMapping("/findbyproduit")
    public List <Images> getImagesByProduit(@RequestParam Produit produit){
        return  iImageService.getByProduit(produit);

    }

}
