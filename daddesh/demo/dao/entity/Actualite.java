package daddesh.demo.dao.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Actualite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String nom ;
     private  String image ;
    @Lob
    @Column(name="lien", length=512)
     private  String lien ;


}
