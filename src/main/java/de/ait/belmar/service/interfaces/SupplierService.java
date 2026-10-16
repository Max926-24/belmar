package de.ait.belmar.service.interfaces;


import de.ait.belmar.dto.supplier.SupplierDto;
import de.ait.belmar.dto.supplier.SupplierSaveDto;

import java.util.List;

public interface SupplierService {

    SupplierDto save (SupplierSaveDto saveDto);

    List<SupplierDto> findAllSuppliers();
}
