package reflect.demo;

import java.lang.reflect.Field;

/**
 * Created by ZPF on 2019/7/3.
 */
public class ReflectDemo3 {
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        getFieldDemo();
    }
    /*
    获取字节码文件中的字段
     */
    public static void getFieldDemo() throws Exception{
        Class clazz =Class.forName("bean.Person");

        //Field field=clazz.getField("name");//只能获取公有的
        //System.out.println(field);报错，因为name字段是私有的。
        Field field=clazz.getDeclaredField("name");//只获取本类，但包含私有字段
        System.out.println(field);

        field.setAccessible(true);//对私有字段的访问取消权限检查,暴力访问

        Object obj=clazz.getConstructor().newInstance();

        field.set(obj,"Faker");

        Object o=field.get(obj);

        System.out.println(o);







    }
}
