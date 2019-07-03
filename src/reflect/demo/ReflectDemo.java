package reflect.demo;

import bean.Person;

/**
 * Created by ZPF on 2019/7/3.
 */
/*
* java反射机制是在运行状态中，对于任意一个类（class文件），都能够得到这个类的所有属性和方法
* 对于任意一个对象，都能够调用它的任意一个方法和属性
* 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
*
* 动态获取类中的信息，就是java反射。
* 可以理解为对类的解剖
* 为什么要用java反射：
* 对于一个已经完成的应用程序，对外提供接口，可以用户拓展
* 想要实现接口的功能，就要创建一个实现类来实现接口，
* 创建的这个实现类的对象怎么被应用程序使用呢？
*
* 在提供接口的同时，对外提供一个配置文件，程序是会读取配置文件的
* 实现类只要把类的名称存到配置文件中，应用程序就可以根据传入的类的名称找到对应的class文件
* 如果找到了class文件，就加载该文件，并获取该文件中所有的内容，之后就能对其调用。
*
* 如果想要对指定名称的字节码文件进行加载并获取其中的内容并调用
* 就要使用反射技术实现。
*
* 好处：大大提高了软件的拓展性，之前通过多态来提高拓展性，但是需要把
* 子类对象new后传入，现在使用反射，只需要把类的名称放入配置文件就可以了
 */

/*
* 要想对字节码文件进行解剖，必须要有字节码文件，
* 如果获取字节码文件对象呢？
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        getClassObject_1();
        getClassObject_2();
        getClassObject_3();
    }
    /*
    * 获取字节码对象的方式：
    * 1.Object类中的getClass()方法
    * 想要用这种方式，必须要明确具体的类，并创建对象，
    * 麻烦
    * 2.任何数据类型都具备一个静态的属性，.class来获取其对应的Class对象
    * 相对简单，但是还是要明确用到类中的静态成员
    * 还是不够扩展
    *3.只要通过给定类的字符串名称，就可以获取该类，更为扩展
    * 可以使用Class类中的方法完成，
    * 该方法就是forName,这种方式只需要类名即可，更具有拓展性
    *
     */
    public static void getClassObject_1(){
        Person p=new Person();
        Class clazz=p.getClass();

        Person p1=new Person();
        Class clazz1=p1.getClass();
        System.out.println(clazz==clazz1);
    }
    public static void getClassObject_2(){
        Class clazz=Person.class;
        Class clazz1=Person.class;
        System.out.println(clazz==clazz1);

    }
    public static void getClassObject_3() throws ClassNotFoundException {
        String classname="bean.Person";
        Class clazz=Class.forName(classname);
        System.out.println(clazz);
    }
}
