package daddesh.demo.dto;


import lombok.Data;

@Data
public class ProduitDto {

    private Long id;
    private String nom;
    private String category;
    private String type;
    private String produit;
    //private String fileName;
    private double prix;
    private Long remise;


}
