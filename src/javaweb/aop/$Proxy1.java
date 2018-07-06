package javaweb.aop;
import java.lang.reflect.Method;
public class $Proxy1 implements javaweb.aop.UserMgr{
    public $Proxy1(InvocationHandler h) {
        this.h = h;
    }
    javaweb.aop.InvocationHandler h;
    @Override
    public  void addUser() {
        try {
        Method md = javaweb.aop.UserMgr.class.getMethod("addUser");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }
    @Override
    public  void delUser() {
        try {
        Method md = javaweb.aop.UserMgr.class.getMethod("delUser");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }

}