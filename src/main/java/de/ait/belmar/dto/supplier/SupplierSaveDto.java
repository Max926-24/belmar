package de.ait.belmar.dto.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SupplierSaveDto {

    @NotBlank(message = "Supplier name is required")
    private String name;

    @Size(max = 50, message = "Phone must be at most 50 characters")
    private String phone;

    @Email(message = "Email must be a valid email address")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("SupplierSaveDto : name=%s, phone=%s, email=%s", name, phone, email);
    }
}
