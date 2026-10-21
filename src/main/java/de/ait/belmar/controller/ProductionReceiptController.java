package de.ait.belmar.controller;

import de.ait.belmar.dto.receipt.ProductionReceiptDto;
import de.ait.belmar.dto.receipt.ProductionReceiptSaveDto;
import de.ait.belmar.service.interfaces.ProductionReceiptService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/production-receipts")
public class ProductionReceiptController {

    private final ProductionReceiptService service;

    public ProductionReceiptController(ProductionReceiptService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductionReceiptDto create(@Valid @RequestBody ProductionReceiptSaveDto saveDto) {
        return service.create(saveDto);
    }

    @GetMapping
    public List<ProductionReceiptDto> getAll() {
        return service.findAll();
    }
}
