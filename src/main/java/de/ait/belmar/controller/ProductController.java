package de.ait.belmar.controller;

import de.ait.belmar.dto.product.ProductDto;
import de.ait.belmar.dto.product.ProductSaveDto;
import de.ait.belmar.service.interfaces.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto save(@Valid @RequestBody ProductSaveDto saveDto) {
        return service.save(saveDto);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return service.findAllProducts();
    }


}
