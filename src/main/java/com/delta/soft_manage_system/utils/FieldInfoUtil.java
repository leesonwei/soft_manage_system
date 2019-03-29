package com.delta.soft_manage_system.utils;

import com.delta.soft_manage_system.AutoField.FieldInfo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GetFieldInfoUtil
 * @Date 2019/3/28 09:44
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public class FieldInfoUtil {

    public static List<String> getFieldInfo(String className) throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        Class clazz = Class.forName(className);
        Field[] fields = clazz.getDeclaredFields();
        FieldInfo f = null;
        for (Field field : fields) {
            f = field.getAnnotation(FieldInfo.class);
            if (null == f) {
                continue;
            }
            list.add(f.value());
        }
        return list;
    }
}
