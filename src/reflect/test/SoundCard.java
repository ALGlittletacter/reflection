package reflect.test;

/**
 * Created by ZPF on 2019/7/3.
 */
public class SoundCard implements PCI{
    public void open(){
        System.out.println("sound open...");

    }
    public void close(){
        System.out.println("sound close...");
    }
}
