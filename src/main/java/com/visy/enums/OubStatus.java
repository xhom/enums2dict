package com.visy.enums;

import com.visy.annotations.EnumDesc;
import com.visy.interfaces.EnumInterface;

@EnumDesc("出库单订单状态")
public enum OubStatus implements EnumInterface {
    ALL_ALLOCATE("300","全部分配"),
    PART_JH("320","部分拣货");

    private String code;
    private String name;
    private String remark;

    OubStatus(String code, String name){
        this.code = code;
        this.name = name;
    }

    OubStatus(String code, String name, String remark){
        this.code = code;
        this.name = name;
        this.remark = remark;
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

    public String getNameByCode(Integer code){
        for(InbStatus status : InbStatus.values()){
            if(code!=null && code.equals(status.getCode())){
                return status.getName();
            }
        }
        return null;
    }
}
