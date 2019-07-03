package bean;

/**
 * Created by ZPF on 2019/7/3.
 */
/*
*
 */
public class Person {
    private int age;
    private String name;
    public Person(int age,String name){
        super();
        this.age=age;
        this.name=name;
        System.out.println("Person param run..."+this.name+":"+this.age);
    }
    public Person(){
        super();
        System.out.println("person run....");
    }
    public void show(){
        System.out.println(name+"...show run ..."+age);

    }
    private void method(){
        System.out.println("method run...");
    }
    public void paramMethod(String name,int num){
        System.out.println("paramMethod run..."+name+":"+num);
    }
    public static void staticMethod(){
        System.out.println("static method run....");
    }
}
