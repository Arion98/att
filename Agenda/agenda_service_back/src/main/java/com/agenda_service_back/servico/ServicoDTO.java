package com.agenda_service_back.servico;

import com.agenda_service_back.agendamento.AgendamentoDTO;
import com.agenda_service_back.categoria.CategoriaDTO;
import com.agenda_service_back.prestador.PrestadorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO {

    private Long servico_id;
    private String servico_nome;
    private Double servico_preco;
    private String servico_descricao;
    private String servico_informacoesExtras;
    private String servico_classificacao;
    private CategoriaDTO categoria;
    private PrestadorDTO prestador;
    private List<AgendamentoDTO> agendamento;
}
