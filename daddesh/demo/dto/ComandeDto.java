package daddesh.demo.dto;

import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class ComandeDto {


    private Long id;

    private LocalDateTime dateTime ;
    private  double totalAmount ;
    private  Long userId ;
    private  List<AddLigneCommandeDto> ligneCommandes ;
}
