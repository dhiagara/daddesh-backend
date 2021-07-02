package daddesh.demo.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String category;
    private String type;
    private String produit;
    //private String fileName;
    private double prix;
    private Long remise;

    @OneToMany (mappedBy = "produit")
    private List<LigneCommande> ligneCommandes;

}
