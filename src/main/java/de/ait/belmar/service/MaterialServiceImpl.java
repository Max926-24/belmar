package de.ait.belmar.service;

import de.ait.belmar.domain.Material;
import de.ait.belmar.dto.mapping.MaterialMapper;
import de.ait.belmar.dto.material.MaterialDto;
import de.ait.belmar.dto.material.MaterialSaveDto;
import de.ait.belmar.repository.MaterialRepository;
import de.ait.belmar.service.interfaces.MaterialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;
    private final MaterialMapper mapper;

    public MaterialServiceImpl(MaterialRepository repository, MaterialMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public MaterialDto save(MaterialSaveDto saveDto) {
        Material entity = mapper.mapDtoToEntity(saveDto);
        entity.setActive(true);
        Material saved = repository.save(entity);
        return mapper.mapEntityToDto(saved);
    }

    @Override
    public List<MaterialDto> findAllMaterials() {
        return repository.findAll()
                .stream()
                .map(mapper::mapEntityToDto)
                .toList();
    }
}
