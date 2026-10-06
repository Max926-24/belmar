package de.ait.belmar.dto.material;

import de.ait.belmar.domain.enums.MaterialType;
import de.ait.belmar.domain.enums.Unit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MaterialSaveDto {

    @NotBlank
    private String name;

    @NotNull
    private MaterialType type;

    @NotNull
    private Unit unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("MaterialSaveDto : name=%s,type=%s,unit=%s", name, type, unit);

    }
}
