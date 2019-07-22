# enums2dict
枚举转数据字典

使用步骤：
# 1.引入
```java
import com.visy.core.*;
import com.visy.annotations.*;
import com.visy.interfaces.*;
```
# 2.在同项目中创建自己的存放枚举类的包：例如<kbd>com.visy.enums</kbd>
## 2-1.你的枚举类需要有三个固定字段：
```java
    private String code;//字典代码
    private String name;//字典名称
    private String remark;//备注
```
## 2-2.你的枚举类需要实现接口：<kbd>EnumInterface</kbd>
如下：
```java
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }

    //通过字典代码获取名称
    public String getNameByCode(String code){
        for(InbStatus status : InbStatus.values()){
            if(code!=null && code.equals(status.getCode())){
                return status.getName();
            }
        }
        return null;
    }
```
## 2-3.添加你自己的枚举值：
```java
    CREATE("100","新建"),
    PALLET_FINISH("260","码盘完成");
```
## 2-4.给枚举类添加注解：<kbd>@EnumDesc("入库单状态")</kbd>以描述枚举的类型

# 3.根据包名获取下面所有枚举类的数据：
```java
    List<DictEntity> dictList = EnumsToDict.getDictsOfPackage("com.visy.enums");
    //DictEntity是一个封装字典数据的对象
    //你可以把这些数据放入数据库以实现同步
    for(DictEntity dict: dictList){
        System.out.println(dict.toString());
    }
    /* 打印结果：
    typeCode=InbStatus,typeName=入库单状态,code=100,name=新建,remark=null
    typeCode=InbStatus,typeName=入库单状态,code=260,name=码盘完成,remark=null
    typeCode=InbStatus,typeName=入库单状态,code=300,name=部分完成,remark=null
    typeCode=InbStatus,typeName=入库单状态,code=310,name=全部完成,remark=null
    typeCode=InbStatus,typeName=入库单状态,code=950,name=关闭,remark=null
    typeCode=InbStatus,typeName=入库单状态,code=999,name=取消,remark=null
    typeCode=OubStatus,typeName=出库单订单状态,code=300,name=全部分配,remark=null
    typeCode=OubStatus,typeName=出库单订单状态,code=320,name=部分拣货,remark=null
    */
    //typeCode取值于枚举类的类名
    //typeName取值于@EnumDesc注解
    //code和name取值于枚举内部的常量
```
   
<kbd>visy.wang</kbd>
