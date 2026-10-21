package de.ait.belmar.dto.product;

import de.ait.belmar.domain.enums.PackagingType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProductSaveDto {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "packaging should not be null")
    private PackagingType packaging;

    @NotNull(message = "netWeight should not be null")
    @DecimalMin(value = "0.001", message = "Net weight must be greater than 0")
    @Digits(integer = 5, fraction = 3, message = "Net weight : max 5 digits before and 3 after the decimal point")
    private BigDecimal netWeight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PackagingType getPackaging() {
        return packaging;
    }

    public void setPackaging(PackagingType packaging) {
        this.packaging = packaging;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    @Override
    public String toString() {
        return String.format("Product : name=%s,packaging=%s,netWeight=%s", name, packaging, netWeight);
    }
}
