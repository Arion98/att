package com.agenda_service_back.endereco;

import com.agenda_service_back.cliente.Cliente;
import com.agenda_service_back.prestador.Prestador;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endereco_id;

    private String endereco_rua;
    private String endereco_cep;

    @Column(unique = false)
    private Integer endereco_numero;

    private String endereco_complemento;
    private String endereco_cidade;
    private String endereco_estado;
    private String endereco_bairro;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "endereco")
    private List<Cliente> cliente;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "endereco")
    private List<Prestador> prestador;
}
