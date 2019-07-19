package com.visy.test;

import com.visy.core.DictEntity;
import com.visy.core.EnumsToDict;

import java.util.List;

public class EnumsToDictTest {
    public static void main(String[] args) {
        List<DictEntity> dictList = EnumsToDict.getDictsOfPackage("com.visy.enums");
        for(DictEntity dict: dictList){
            System.out.println(dict.toString());
        }
    }
}
