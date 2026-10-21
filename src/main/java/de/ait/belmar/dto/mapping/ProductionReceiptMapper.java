package de.ait.belmar.dto.mapping;


import de.ait.belmar.domain.ProductionReceipt;
import de.ait.belmar.domain.ProductionReceiptItem;
import de.ait.belmar.dto.receipt.ProductionReceiptDto;
import de.ait.belmar.dto.receipt.ReceiptItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductionReceiptMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "packaging", source = "product.packaging")
    @Mapping(target = "netWeight", source = "product.netWeight")
    ReceiptItemDto mapItemToDto(ProductionReceiptItem item);

    @Mapping(target = "createdBy", source = "createdBy.username")
    ProductionReceiptDto mapEntityToDto(ProductionReceipt receipt);

}
