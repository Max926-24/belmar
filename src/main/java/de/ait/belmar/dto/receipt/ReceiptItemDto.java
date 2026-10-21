package de.ait.belmar.dto.receipt;

import de.ait.belmar.domain.enums.PackagingType;

import java.math.BigDecimal;


public class ReceiptItemDto {

    private Long id;
    private Long productId;
    private String productName;
    private PackagingType packaging;
    private BigDecimal netWeight;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
        return String.format("ReceiptItemDto: id=%s,productId=%s,productName=%s,packaging=%s,netWeight=%s,quantity=%s",
                id, productId, productName, packaging, netWeight, quantity);
    }
}
