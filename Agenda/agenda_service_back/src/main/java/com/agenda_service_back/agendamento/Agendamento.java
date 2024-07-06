package com.agenda_service_back.agendamento;

import com.agenda_service_back.cliente.Cliente;
import com.agenda_service_back.enums.StatusEnum;
import com.agenda_service_back.prestador.Prestador;
import com.agenda_service_back.servico.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendamentos")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agendamento_id;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prestador_id")
    private Prestador prestador;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern ="HH:mm")
    private LocalTime agendamento_hora;
    private String agendamento_observacoes;
    
     @Enumerated(EnumType.STRING)
    private StatusEnum agendamento_status;
    
    private LocalDateTime dataAgendamento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_id")
    private Servico servico;

    private String observacoes;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
