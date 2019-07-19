package com.visy.demos;

import java.util.List;

public class EnumsToDictTest {
    public static void main(String[] args) {
        List<DictEntry> dictList = EnumsToDict.getDictsOfPackage("com.visy.enums");
        for(DictEntry dict: dictList){
            System.out.println(dict.toString());
        }
    }
}
