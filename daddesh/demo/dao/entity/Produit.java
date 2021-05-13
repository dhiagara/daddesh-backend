package daddesh.demo.dao.entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="ligne_commande", nullable=true)
    private LigneCommande ligneCommande;

}
