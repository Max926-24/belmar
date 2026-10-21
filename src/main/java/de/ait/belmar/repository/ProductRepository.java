package de.ait.belmar.repository;

import de.ait.belmar.domain.Product;
import de.ait.belmar.domain.enums.PackagingType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByNameAndPackagingAndNetWeight(String name,
                                                 PackagingType packaging,
                                                 BigDecimal netWeight);

}
