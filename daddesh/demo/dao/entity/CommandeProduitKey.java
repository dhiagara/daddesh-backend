package daddesh.demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CommandeProduitKey implements Serializable {
    @Column(name="produit_id")
    Long idProduit ;

    @Column(name="commande_id")
    Long idCommande;
}
