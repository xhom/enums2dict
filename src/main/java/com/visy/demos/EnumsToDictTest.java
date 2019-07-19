package com.visy.demos;

import java.util.List;

public class EnumsToDictTest {
    public static void main(String[] args) {
        List<DictEntity> dictList = EnumsToDict.getDictsOfPackage("com.visy.enums");
        for(DictEntity dict: dictList){
            System.out.println(dict.toString());
        }
    }
}
