package javaweb.aop;

public class UserMgrImpl implements UserMgr {
    @Override
    public void addUser() {
        System.out.println("模拟aop,添加用户");

    }

    @Override
    public void delUser() {
        System.out.println("模拟aop，删除用户");
    }
}
