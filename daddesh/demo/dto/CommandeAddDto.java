package daddesh.demo.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandeAddDto {
    private LocalDateTime dateTime ;
    private  double totaleAmount ;
    private Long userId ;
    private List<AddLigneCommandeDto> ligneCommande ;
}
