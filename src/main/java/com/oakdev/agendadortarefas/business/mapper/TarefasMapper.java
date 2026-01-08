package com.oakdev.agendadortarefas.business.mapper;


import com.oakdev.agendadortarefas.business.dto.TarefasDTO;
import com.oakdev.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasMapper {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);


    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> entities);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> dtos);


}
