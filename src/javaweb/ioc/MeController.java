package javaweb.ioc;

import java.lang.reflect.InvocationTargetException;

public class MeController {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        MeController meController =new MeController();
        Me me =(Me)meController.springDo();
        me.meSpeak(); // 这里如果是普通调用会报空指针异常，而容器却为其将rain这个变量赋值了，所以可以正常输出
    }

    /*
    模拟Spring启动过程，这一步其实可以单独写一个类，这一步是容器该做的，而我们并不需要去管
     */
    public Object springDo() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MeReflect meReflect =new MeReflect(); // 启动的时候就需要加载的
        Me me =new Me();                     //扫描类注解后new操作然后进行下一步
        meReflect.get_ref(me);                    // 将其类里面的变量进行new操作并放入容器
        Object object =meReflect.returnList().get(0);
        return object;
    }
}
