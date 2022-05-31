package com.LetsCode.Productservice.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity //representa entidade de banco de dados
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id //chave da tabela
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String categoryname;

    private Long id;

}
