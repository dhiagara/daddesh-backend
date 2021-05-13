package daddesh.demo.dao.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    Boolean status =false ;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="produit_id", nullable=false)
    private Produit produit;



    @JsonIgnore
    @OneToOne(mappedBy = "commande")
    private LigneCommande ligneCommande;
}
