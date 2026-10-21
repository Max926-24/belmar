package de.ait.belmar.repository;

import de.ait.belmar.domain.ProductionReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionReceiptRepository extends JpaRepository<ProductionReceipt, Long> {
}
