package de.ait.belmar.dto.material;

import de.ait.belmar.domain.enums.MaterialType;
import de.ait.belmar.domain.enums.Unit;

public class MaterialDto {

    private Long id;
    private String name;
    private MaterialType type;
    private Unit unit;
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

    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("MaterialDto: id=%s,name=%s,type=%s,unit=%s,active=%s",
                id, name, type, unit, active);
    }
}
