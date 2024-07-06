package com.agenda_service_back.categoria;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.agenda_service_back.servico.Servico;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long categoria_id;
    private String categoria_nome;
    private String categoria_descricao;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Servico> servico;

}