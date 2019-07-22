package com.visy.enums2dict.enums;

import com.visy.enums2dict.annotations.EnumDesc;
import com.visy.enums2dict.interfaces.EnumInterface;

@EnumDesc("入库单状态")
public enum InbStatus implements EnumInterface {
    CREATE("100","新建"),
    PALLET_FINISH("260","码盘完成"),
    PART_FINISH("300", "部分完成"),
    FULL_FINISH("310","全部完成"),
    CLOSE("950", "关闭"),
    CANCEL("999", "取消");

    private String code;
    private String name;
    private String remark;

    InbStatus(String code, String name){
        this.code = code;
        this.name = name;
    }

    InbStatus(String code, String name, String remark){
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

    public String getNameByCode(String code){
        for(InbStatus status : InbStatus.values()){
            if(code!=null && code.equals(status.getCode())){
                return status.getName();
            }
        }
        return null;
    }
}
