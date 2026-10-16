package de.ait.belmar.repository;

import de.ait.belmar.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    boolean existsByName(String name);
}
