package javaweb.thread;

public class RunMethod implements Runnable{
    @Override
    public void run() {
        //快捷方式sout,run方法中相当另一线程

        System.out.println("Another new thread starts");
    }
}
