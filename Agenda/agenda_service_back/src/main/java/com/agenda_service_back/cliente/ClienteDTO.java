package com.agenda_service_back.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

import com.agenda_service_back.endereco.EnderecoDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private Long cliente_id;
    private String cliente_nome;
    private String cliente_cpf;
    private String email;
    private String cliente_senha;
    private LocalDate cliente_dataNascimento;
    private EnderecoDTO endereco;
}
