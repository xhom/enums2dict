package com.visy.enums2dict.test;

import com.visy.enums2dict.core.DictEntity;
import com.visy.enums2dict.core.EnumsToDict;

import java.util.List;

public class EnumsToDictTest {
    public static void main(String[] args) {
        List<DictEntity> dictList = EnumsToDict.getDictsOfPackage("com.visy.enums2dict.enums");
        for(DictEntity dict: dictList){
            System.out.println(dict.toString());
        }
    }
}
