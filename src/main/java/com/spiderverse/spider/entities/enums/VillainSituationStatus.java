package com.spiderverse.spider.entities.enums;

public enum VillainSituationStatus {

    CAPTURED(1),
    FREE(2),
    DEAD(3),
    INJURED(4);

    private int code;

    private VillainSituationStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VillainSituationStatus valueSituationVillain(int code) {
        for(VillainSituationStatus value : VillainSituationStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code status!");
    }
}
