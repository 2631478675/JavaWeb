package javaweb.ioc;

@LikeService
public class Me {
    private String address;

    @LikeAutowired
    Person person;

    public void meSpeak(){
       person.speak();
    }
}
