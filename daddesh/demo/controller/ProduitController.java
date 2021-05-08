package daddesh.demo.controller;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daddesh.demo.dao.entity.Images;
import daddesh.demo.dao.entity.Produit;
import daddesh.demo.dao.entity.User;
import daddesh.demo.service.IImageService;
import daddesh.demo.service.IProduitService;
import daddesh.demo.service.impl.UserServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("/produit")
@CrossOrigin
public class ProduitController {


    @Autowired
    ServletContext context;
    @Autowired
    private IProduitService produitService;
    @Autowired
    private IImageService iImageService ;

    @GetMapping("/")
    public List<Produit> getProduits(){
        return  produitService.getAllProduits();

    }
    @GetMapping("/find")
    public Produit getProduit(@RequestParam Long id){
        return  produitService.findById(id);

    }
    @GetMapping(path="/findImage/{id}/{num}")
    public byte[] getImageProduit(@PathVariable("id") Long id,@PathVariable("num") int num)throws Exception{
        Produit p = produitService.findById(id);
        List<Images> im = iImageService.getByProduit(p);

        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+im.get(num).getNom()));

    }

    @PostMapping("/add")
    public Produit addProduit(@RequestParam("file[]") MultipartFile file[],
                              @RequestParam("produit") String produit)
            throws JsonParseException, JsonMappingException, Exception
    {
        Produit prod = new ObjectMapper().readValue(produit, Produit.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        System.out.println("mk filéé............."+file );
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        produitService.add(prod);
        for (MultipartFile fil:file
             ) {
            String filename = fil.getOriginalFilename();
            String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
            File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
            try
            {

                FileUtils.writeByteArrayToFile(serverFile,fil.getBytes());

            }catch(Exception e) {
                e.printStackTrace();
            }
            Images im =new Images();
            im.setNom(newFileName);
            im.setProduit(prod);
            iImageService.addImages(im);

        }






        return  prod;

    }
    @DeleteMapping("/remove")
    public boolean deleteProduit(@RequestParam Long id){
        return  produitService.deleteById(id);

    }
    @PutMapping ("/update")
    public boolean updateProduit(@RequestBody Produit produit){
        return  produitService.update(produit);

    }

}
