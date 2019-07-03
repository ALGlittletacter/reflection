package reflect.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by ZPF on 2019/7/3.
 */
/*
* 电脑运行。
 */
public class ReflectTest {
    /**
     * @param args
     */
    public static void main(String[] args)throws Exception{
        MainBoard mb=new MainBoard();
        mb.run();
        //存在的问题：
        //每次添加一个设备都需要修改代码传递一个新创建的对象
        //能不能不修改代码就可以完成这个动作
        //解决方法：不用new来完成，而是直接获取其class文件，在内部实现创建对象的动作。
        //正常来说用xml配置文件，这里简单用properties简单实现
        File configFile=new File("PCI.properties");
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(configFile);
        prop.load(fis);

        for(int x=0;x<prop.size();x++){
            String pciName=prop.getProperty("PCI"+(x+1));
            Class clazz=Class.forName(pciName);//加载这个类
            PCI p=(PCI)clazz.getConstructor().newInstance();
            mb.use(p);
        }
        fis.close();
    }
}
