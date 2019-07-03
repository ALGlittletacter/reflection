package reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ZPF on 2019/7/3.
 */
public class ReflectDemo2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        createNewObject_2();
    }

    public static void createNewObject_2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //bean.Person p=new bean.Person(23,"Alien");
        //当要获取指定名称对应的类中所体现的对象时，
        //而该对象初始化不适用空参数构造函数时，要怎么办？

        //既然是通过指定的构造函数进行对象的初始化，
        //所以应该先获取到该构造函数
        //通过字节码文件对象即可完成，该方法是getConstructor()

        String name="bean.Person";
        Class clazz=Class.forName(name);
        //获取到了指定的构造函数对象
        Constructor constructor=clazz.getConstructor(int.class,String.class);
        //通过该构造器对象的newInstance方法进行对象的初始化
        Object obj=constructor.newInstance(24,"EZRL");
    }

    public static void createNewObject() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //早期创建对象的方法：new的时候，先根据被new的类的名称找寻该类的字节码文件
        //并加载进内存，并创建该字节码文件对象，
        // 并借着创建该字节码文件对应的Person对象
        bean.Person p=new bean.Person();
        //现在：只有字符串名字，也想完成创建对象的动作
        String name="bean.Person";
        //找寻该名称类文件，并加载进内存，并产生Class对象
        Class clazz=Class.forName(name);
        //如何产生该类的对象呢？
        //使用newInstance方法
        Object obj=clazz.getConstructor().newInstance();

    }
}
