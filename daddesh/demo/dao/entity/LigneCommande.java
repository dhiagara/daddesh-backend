package daddesh.demo.dao.entity;
import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LigneCommande {

    @EmbeddedId
    private CommandeProduitKey id;

    @ManyToOne
    @MapsId("idCommande")
    @JoinColumn(name = "commande_id")
    private  Commande commande ;

    @ManyToOne
    @MapsId("idProduit")
    @JoinColumn(name = "id_produit")
    private  Produit produit ;


    private String nom;
    private String prenom;
    private String emailId;
    private String password;
    private String telephone;
    private String adresse;
    private String codePostal;
    private Long numCommande ;

    private  double prix ;


}
