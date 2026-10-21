package de.ait.belmar.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "production_receipt_item")
public class ProductionReceiptItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receipt_id")
    private ProductionReceipt receipt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public ProductionReceiptItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductionReceipt getReceipt() {
        return receipt;
    }

    public void setReceipt(ProductionReceipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductionReceiptItem productionReceiptItem))
            return false;
        return id != null && Objects.equals(id, productionReceiptItem.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return String.format("ProductionReceiptItem : id=%s,productId=%s,quantity=%s",id,product !=null ? product.getId() : null, quantity);
    }
}
