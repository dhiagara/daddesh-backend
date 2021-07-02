package daddesh.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddLigneCommandeDto {


  private Long idProduit ;
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
