package de.ait.belmar.dto.mapping;


import de.ait.belmar.domain.Product;
import de.ait.belmar.dto.product.ProductDto;
import de.ait.belmar.dto.product.ProductSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto mapEntityToDto(Product entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Product mapDtoToEntity(ProductSaveDto dto);


}
