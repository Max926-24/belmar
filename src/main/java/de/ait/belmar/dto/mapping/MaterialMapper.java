package de.ait.belmar.dto.mapping;

import de.ait.belmar.domain.Material;
import de.ait.belmar.dto.material.MaterialDto;
import de.ait.belmar.dto.material.MaterialSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MaterialMapper {

    MaterialDto mapEntityToDto(Material entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Material mapDtoToEntity(MaterialSaveDto dto);
}
