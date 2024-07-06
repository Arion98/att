package com.agenda_service_back.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.util.List;

import com.agenda_service_back.cliente.ClienteDTO;
import com.agenda_service_back.prestador.PrestadorDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO implements Serializable {
    private Long endereco_id;
    private String endereco_rua;
    private String endereco_cep;
    private Integer endereco_numero;
    private String endereco_complemento;
    private String endereco_cidade;
    private String endereco_estado;
    private String endereco_bairro;
    
    private List<ClienteDTO> cliente;

    private List<PrestadorDTO> prestador;

}
