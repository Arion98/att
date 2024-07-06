package com.agenda_service_back.prestador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.telefone.Telefone;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorDTO implements Serializable {
    private Long prestador_id;
    private String prestador_nome;
    private String prestador_cnpj;
    private String prestador_cpf;
    private String prestador_razaoSocial;
    private String prestador_email;
    private String prestador_senha;
    private Endereco endereco;
    private List<Servico> servico;
    private List<Telefone> telefone;
}
