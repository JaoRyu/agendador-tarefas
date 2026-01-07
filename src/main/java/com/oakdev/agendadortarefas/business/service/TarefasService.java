package com.oakdev.agendadortarefas.business.service;

import com.oakdev.agendadortarefas.business.dto.TarefasDTO;
import com.oakdev.agendadortarefas.business.mapper.TarefasMapper;
import com.oakdev.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.oakdev.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.oakdev.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.oakdev.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasMapper tarefasMapper;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasMapper.paraTarefaEntity(dto);
        return tarefasMapper.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
