package com.agenda_service_back.agendamento;

import com.agenda_service_back.cliente.ClienteMapper;
import com.agenda_service_back.prestador.PrestadorMapper;
import com.agenda_service_back.servico.ServicoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, PrestadorMapper.class, ServicoMapper.class})
public interface AgendamentoMapper {

    @Mapping(source = "agendamento_id", target = "agendamento_id")
    AgendamentoDTO toDTO(Agendamento agendamento);

    @Mapping(source = "agendamentoDTO.agendamento_id", target = "agendamento_id")
    Agendamento toEntity(AgendamentoDTO agendamentoDTO);

    List<AgendamentoDTO> toDTO(List<Agendamento> agendamentos);

    @Mappings({
            @Mapping(source = "agendamentoDTO.agendamento_id", target = "agendamento_id"),
            @Mapping(source = "agendamentoDTO.prestador", target = "prestador"),
            @Mapping(source = "agendamentoDTO.servico", target = "servico"),
            @Mapping(source = "agendamentoDTO.dataAgendamento", target = "dataAgendamento"),
            @Mapping(source = "agendamentoDTO.agendamento_observacoes", target = "agendamento_observacoes"),
            @Mapping(target = "cliente", ignore = true) // Ignorando cliente para evitar ciclos infinitos
    })
    Agendamento updateEntity(AgendamentoDTO agendamentoDTO, Agendamento agendamento);

    @Mappings({
            @Mapping(source = "agendamentoDTO.prestador", target = "prestador"),
            @Mapping(source = "agendamentoDTO.servico", target = "servico"),
            @Mapping(source = "agendamentoDTO.dataAgendamento", target = "dataAgendamento"),
            @Mapping(source = "agendamentoDTO.observacoes", target = "observacoes")
    })
    void updateEntityFromDTO(AgendamentoDTO agendamentoDTO, Agendamento agendamento);
}
