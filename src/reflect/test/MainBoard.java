package reflect.test;

/**
 * Created by ZPF on 2019/7/3.
 */
public class MainBoard {
    public void run(){
        System.out.println("主板运行中...");
    }
    public void use(PCI c){
        if( c!=null){
            c.open();
            c.close();
        }
    }
}
