package daddesh.demo.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String emailId;
    private String password;
    private String telephone;
    private String adresse;
    private String codePostal;
    private  Long numCommande ;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Commande_id")
    private Commande commande;

    @OneToMany(mappedBy="ligneCommande", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private List<Produit> produit;






}
