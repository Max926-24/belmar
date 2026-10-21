package de.ait.belmar.service.interfaces;

import de.ait.belmar.dto.receipt.ProductionReceiptDto;
import de.ait.belmar.dto.receipt.ProductionReceiptSaveDto;

import java.util.List;

public interface ProductionReceiptService {

    ProductionReceiptDto create(ProductionReceiptSaveDto saveDto);

    List<ProductionReceiptDto> findAll();
}
