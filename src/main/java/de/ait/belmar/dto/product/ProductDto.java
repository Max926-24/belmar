package de.ait.belmar.dto.product;

import de.ait.belmar.domain.enums.PackagingType;

import java.math.BigDecimal;

public class ProductDto {

    private Long id;
    private String name;
    private PackagingType packaging;
    private BigDecimal netWeight;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("Product Dto : id=%s,name=%s," +
                "packaging=%s,netWeight=%s,active=%s", id, name, packaging, netWeight, active);
    }
}
