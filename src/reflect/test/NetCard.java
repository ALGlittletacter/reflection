package reflect.test;

/**
 * Created by ZPF on 2019/7/3.
 */
public class NetCard implements PCI{

    @Override
    public void open() {
        System.out.println("网卡启动");
    }

    @Override
    public void close() {
        System.out.println("网卡关闭");
    }
}
