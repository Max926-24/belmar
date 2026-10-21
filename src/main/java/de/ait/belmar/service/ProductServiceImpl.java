package de.ait.belmar.service;

import de.ait.belmar.domain.Product;
import de.ait.belmar.dto.mapping.ProductMapper;
import de.ait.belmar.dto.product.ProductDto;
import de.ait.belmar.dto.product.ProductSaveDto;
import de.ait.belmar.exceptions.DuplicateEntityException;
import de.ait.belmar.repository.ProductRepository;
import de.ait.belmar.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ProductDto save(ProductSaveDto saveDto) {
        if (repository.existsByNameAndPackagingAndNetWeight(
                saveDto.getName(), saveDto.getPackaging(), saveDto.getNetWeight())) {
            throw new DuplicateEntityException(String.format(
                    "Product %s %s %s kg already exists",
                    saveDto.getName(), saveDto.getPackaging(), saveDto.getNetWeight()));
        }
        Product entity = mapper.mapDtoToEntity(saveDto);
        entity.setActive(true);
        Product saved = repository.save(entity);
        return mapper.mapEntityToDto(saved);

    }

    @Override
    public List<ProductDto> findAllProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::mapEntityToDto)
                .toList();
    }
}
