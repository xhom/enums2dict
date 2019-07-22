package com.visy.enums2dict.core;

public class DictEntity {
    private String typeCode;
    private String typeName;
    private String code;
    private String name;
    private String remark;

    DictEntity(){}

    DictEntity(String code, String name, String remark){
        this.code = code;
        this.name = name;
        this.remark = remark;
    }
    DictEntity(String typeCode, String code, String name, String remark){
        this.typeCode = typeCode;
        this.code = code;
        this.name = name;
        this.remark = remark;
    }
    DictEntity(String typeCode, String typeName, String code, String name, String remark){
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.code = code;
        this.name = name;
        this.remark = remark;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }

    public String toString(){
        return "typeCode="+this.getTypeCode()+",typeName="+this.getTypeName()+",code="+this.getCode()+",name="+this.getName()+",remark="+this.getRemark();
    }
}