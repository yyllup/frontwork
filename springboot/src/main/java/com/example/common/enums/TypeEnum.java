package com.example.common.enums;

public enum TypeEnum {//枚举信息来源
    // 失物广场区域
    LOST("失物广场"),
    //招领广场
    FIND("招领广场"),
    ;
    public String type;
    TypeEnum(String type) {
        this.type = type;
    }
}
