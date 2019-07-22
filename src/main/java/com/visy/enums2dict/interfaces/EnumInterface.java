package com.visy.enums2dict.interfaces;

public interface EnumInterface {

    String getCode();

    String getName();

    String getRemark();

    /**
     * 通过代码获取名称
     */
    String getNameByCode(String code);
}
