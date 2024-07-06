package com.agenda_service_back.agendamento;

import com.agenda_service_back.cliente.ClienteDTO;
import com.agenda_service_back.enums.StatusEnum;
import com.agenda_service_back.prestador.PrestadorDTO;
import com.agenda_service_back.servico.ServicoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long agendamento_id;

    private PrestadorDTO prestador;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime agendamento_hora;

    private String agendamento_observacoes;

    private StatusEnum agendamento_status;

    private LocalDateTime dataAgendamento;

    private ServicoDTO servico;

    private ClienteDTO cliente;
}
