package de.ait.belmar.service.interfaces;

import de.ait.belmar.dto.material.MaterialDto;
import de.ait.belmar.dto.material.MaterialSaveDto;

import java.util.List;

public interface MaterialService {

    MaterialDto save(MaterialSaveDto saveDto);

    List<MaterialDto> findAllMaterials();
}
