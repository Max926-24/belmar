package de.ait.belmar.controller;


import de.ait.belmar.dto.material.MaterialDto;
import de.ait.belmar.dto.material.MaterialSaveDto;
import de.ait.belmar.service.interfaces.MaterialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    private final MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialDto save(@Valid @RequestBody MaterialSaveDto saveDto) {
        return service.save(saveDto);
    }

    @GetMapping
    public List<MaterialDto> getAll() {
        return service.findAllMaterials();
    }
}
