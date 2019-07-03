package reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by ZPF on 2019/7/3.
 */
public class ReflectDemo4 {
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        getMethodDemo_3();
    }

    public static void getMethodDemo_3() throws Exception{
        Class clazz=Class.forName("bean.Person");
        //获取指定的方法
        Method method=clazz.getMethod("paramMethod", String.class, int.class);//获取空参数一般方法
        Object obj=clazz.getConstructor().newInstance();

        method.invoke(obj,"XDD",89);
    }

    public static void getMethodDemo() throws Exception{
        Class clazz=Class.forName("bean.Person");
        Method[] methods=clazz.getMethods();//获取的都是共有的方法。
        methods=clazz.getDeclaredMethods();//获取本类中的所有方法，不获取父类的
        for(Method m:methods){
            System.out.println(m);
        }
    }
    public static void getMethodDemo_2() throws Exception{
        Class clazz=Class.forName("bean.Person");
        //获取指定的方法
        Method method=clazz.getMethod("show",null);//获取空参数一般方法
//        Constructor constructor=clazz.getConstructor(int.class,String.class);
//        Object obj=constructor.newInstance(23,"小米");
        Object obj=clazz.getConstructor(int.class,String.class).newInstance(23,"Pawn");
        method.invoke(obj,null);

    }
}
