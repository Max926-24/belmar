package de.ait.belmar.dto.receipt;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class ProductionReceiptSaveDto {

    @NotNull(message = "Document date is required")
    private LocalDate docDate;


    @NotEmpty(message = "Receipt must contain at least one item")
    @Valid
    private List<ReceiptItemSaveDto> items;

    public LocalDate getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    public List<ReceiptItemSaveDto> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItemSaveDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return String.format("ProductionReceiptSaveDto: docDate=%s,items=%s", docDate, items);
    }
}
