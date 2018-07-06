package javaweb.ioc;

@LikeService
public class Person {
    private String name;
    private String age;


    public void speak(){
        System.out.println("我是一个人");
    }
}
