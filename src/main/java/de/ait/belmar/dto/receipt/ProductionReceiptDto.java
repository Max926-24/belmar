package de.ait.belmar.dto.receipt;

import de.ait.belmar.domain.enums.DocumentStatus;

import java.time.LocalDate;
import java.util.List;

public class ProductionReceiptDto {

    private Long id;
    private LocalDate docDate;
    private DocumentStatus status;
    private String createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<ReceiptItemDto> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItemDto> items) {
        this.items = items;
    }

    private List<ReceiptItemDto> items;

    @Override
    public String toString() {
        return String.format("ProductionReceiptDto: id=%s,docDate=%s,status=%s,createdBy=%s,items=%s",
                id, docDate, status, createdBy, items);
    }
}
