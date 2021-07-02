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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    Boolean status =false ;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="produit_id")
    private Produit produit;

   @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    private List<LigneCommande> ligneCommandes ;



}
