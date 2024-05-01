package com.example.common.enums;

public enum FlowerModuleEnum {
    SUGGESTION("建议"),
    FIND("招领广场");

    FlowerModuleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private  String value;
}
