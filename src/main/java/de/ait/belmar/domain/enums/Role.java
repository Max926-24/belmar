package de.ait.belmar.domain.enums;

public enum Role {

    ROLE_SYSADMIN(0),
    ROLE_DIRECTOR(100),
    ROLE_MANAGER(90),
    ROLE_CHIEF_ACCOUNTANT(90),
    ROLE_ACCOUNTANT(70),
    ROLE_SALES_REP(30),
    ROLE_TECHNOLOGIST(30),
    ROLE_STOREKEEPER(30);

    public static final int VIEW_OTHERS_LEVEL = 70;

    private final int level;

    Role(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean canViewOthers() {
        return level >= VIEW_OTHERS_LEVEL;
    }


}
