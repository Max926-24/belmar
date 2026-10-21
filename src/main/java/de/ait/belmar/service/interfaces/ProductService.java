package de.ait.belmar.service.interfaces;

import de.ait.belmar.dto.product.ProductDto;
import de.ait.belmar.dto.product.ProductSaveDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductSaveDto saveDto);

    List<ProductDto> findAllProducts();
}
