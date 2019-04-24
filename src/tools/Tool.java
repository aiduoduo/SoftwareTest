package tools;

import object.Paper;
import object.Request;

/**
 * Created by admin on 2019/4/23.
 */
public class Tool {
    /*条目与属性名称对应规定，如下：
     * point——knowledge_point
     * difficulty——difficluty
     */
    private static final int[] typeIndex = {1,2,3,17,83};
    private static final String[] types = {"1","2","3","17","83"};//TODO:将数字更改为题目类型对应的英文名称
    private static final String[] properties = {"point","difficulty"};//TODO:完善组卷需求对应的条目
    private static final String[] propertyNames = {"knowledge_point","difficulty"};//TODO:完善组卷需求条目对应的数据库中属性名称

    public static Request[] generateRequest(String message){
        Request[] request = null;
        //TODO:解析信息，完善信息类

        return request;
    }
    //将paper对象转换为JSON字符串
    public static String getJSON(Paper paper){
        String json = "";
        //TODO:将paper对象转换为JSON对字符串

        return json;
    }
    //生成选择条件
    public static String generateCondition(String[] names,int[] values ){
        int length = names.length;
        if(values.length!=length||length==0)
            return "";
        String condition = names[0] + " = " + values[0];
        for(int i = 1;i<length;i++)
            condition = condition + " and "+ names[i] + " = " + values[i];
        return condition;
    }
    //获得题目类型对应的id
    public static int getTypeIndex(String typeName){
        int index = -1;
        for(int i = 0;i<types.length;i++){
            if(types[i].equals(typeName)) {
                index = typeIndex[i];
                break;
            }
        }
        return index;
    }
    //获得条目对应的数据库中属性名称
    public static String getProperty(String propertyName){
        String name = "";
        for(int i = 0;i<properties.length;i++){
            if(properties[i].equals(propertyName)) {
                name = propertyNames[i];
                break;
            }
        }
        return name;
    }
    //获得需求条目
    public static String[] getAllProperties(){
        return propertyNames;
    }
    //获得题目类型
    public static String[] getAllTypes(){
        return types;
    }

}
