package com.spiderverse.spider.entities.enums;

public enum SpiderSituationStatus {
    ON_MISSION(1),
    FREE(2),
    INJURED(3);

    private int code;

    private SpiderSituationStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SpiderSituationStatus valueSituation(int code) {
        for(SpiderSituationStatus value : SpiderSituationStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code status!");
    }
}
