package daddesh.demo.dao.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom ;
    @ManyToOne
    @JoinColumn(name="produit_id", nullable=false)
    private Produit produit;
}
