package de.ait.belmar.domain;

import de.ait.belmar.domain.enums.PackagingType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "packaging",nullable = false)
    @Enumerated(EnumType.STRING)
    private PackagingType packaging;

    @Column(name = "net_weight", nullable = false, precision = 8, scale = 3)
    private BigDecimal netWeight;


    @Column(name = "active", nullable = false)
    private boolean active;

    public Product() {
    }

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product product))
            return false;
        return id != null && Objects.equals(id, product.id);

    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", packaging=" + packaging +
                ", netWeight=" + netWeight +
                ", active=" + active +
                '}';
    }
}
