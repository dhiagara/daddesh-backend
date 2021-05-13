package daddesh.demo.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String context;
    @Lob
    @Column(name="contenue", length=512)
    private String contenue;

    private  String image ;
    private Date  date ;
}
