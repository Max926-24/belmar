package de.ait.belmar.dto.mapping;


import de.ait.belmar.domain.Supplier;
import de.ait.belmar.dto.supplier.SupplierDto;
import de.ait.belmar.dto.supplier.SupplierSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierDto mapEntityToDto(Supplier entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Supplier mapDtoToEntity(SupplierSaveDto dto);
}
