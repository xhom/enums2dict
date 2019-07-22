package com.visy.enums2dict.core;

import com.visy.enums2dict.annotations.EnumDesc;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EnumsToDict {

    //获取指定包下的所有类路径
    private static List<String> getClassesByPackage(String packagePath) {
        //获取包的文件路径
        String basePath = ClassLoader.getSystemResource("").getPath();
        String filePath = basePath + packagePath.replace(".", "/");

        //获取包下所有类路径
        List<String> classPathList = new ArrayList<String>();
        getClassPaths(filePath, classPathList);

        return classPathList;
    }

    private static void getClassPaths(String rootPath, List<String> result){
        File rootFile = new File(rootPath);
        File[] children = rootFile.listFiles();
        if(children==null){
            result.add(classPathPickUp(rootFile.getPath()));
            return;
        }
        for(File child: children){
            String childPath = child.getPath();
            if(child.isDirectory()){
                getClassPaths(childPath, result);
            }else{
                result.add(classPathPickUp(childPath));
            }
        }
    }

    //从文件路径提取类路径
    private static String classPathPickUp(String filePath){
        if(filePath!=null && !"".equals(filePath)){
            int start = filePath.indexOf("classes");
            int end = filePath.indexOf(".class");
            String classPath = filePath.substring(start,end).replace("\\",".");
            return classPath.replace("classes.","");
        }
        return filePath;
    }

    //获取指定枚举类的全部数据
    private static List<DictEntity>  getDataByClass(String classPath){
        List<DictEntity> dictList = new ArrayList<DictEntity>();
        try{
            Class<?> clazz = Class.forName(classPath);
            Object[] values = clazz.getEnumConstants();

            EnumDesc enumDesc =  clazz.getAnnotation(EnumDesc.class);
            String typeName = enumDesc!=null ? enumDesc.value() : null;

            Method m1 = clazz.getDeclaredMethod("getCode");
            Method m2 = clazz.getDeclaredMethod("getName");
            Method m3 = clazz.getDeclaredMethod("getRemark");
            Method.setAccessible(new Method[]{m1,m2,m3},true);

            for(Object value: values){
                String typeCode = value.getClass().getSimpleName();
                String code = (String)m1.invoke(value);
                String name = (String)m2.invoke(value);
                String remark = (String)m3.invoke(value);
                DictEntity dict = new DictEntity(typeCode,typeName,code,name,remark);
                dictList.add(dict);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return dictList;
    }

    //获取指定包下所有枚举配置数据
    public static List<DictEntity> getDictsOfPackage(String pkgPath) {
        List<String> list = getClassesByPackage(pkgPath);
        List<DictEntity> dictList = new ArrayList<DictEntity>();
        for(String path: list){
            dictList.addAll(getDataByClass(path));
        }
        return dictList;
    }
}