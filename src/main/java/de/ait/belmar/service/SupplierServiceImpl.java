package de.ait.belmar.service;

import de.ait.belmar.domain.Supplier;
import de.ait.belmar.dto.mapping.SupplierMapper;
import de.ait.belmar.dto.supplier.SupplierDto;
import de.ait.belmar.dto.supplier.SupplierSaveDto;
import de.ait.belmar.exceptions.DuplicateEntityException;
import de.ait.belmar.repository.SupplierRepository;
import de.ait.belmar.service.interfaces.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;
    private final SupplierMapper mapper;

    public SupplierServiceImpl(SupplierRepository repository, SupplierMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public SupplierDto save(SupplierSaveDto saveDto) {
        if (repository.existsByName(saveDto.getName())) {
            throw new DuplicateEntityException(
                    "Supplier with name " + saveDto.getName() + " already exists"
            );
        }
        Supplier entity = mapper.mapDtoToEntity(saveDto);
        entity.setActive(true);
        Supplier saved = repository.save(entity);
        return mapper.mapEntityToDto(saved);


    }

    @Override
    public List<SupplierDto> findAllSuppliers() {
        return repository.findAll()
                .stream()
                .map(mapper::mapEntityToDto)
                .toList();
    }

}
