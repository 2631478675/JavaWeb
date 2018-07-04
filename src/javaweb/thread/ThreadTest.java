package javaweb.thread;

public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("the first thread running");
        RunMethod runMethod = new RunMethod();
        Thread thread = new Thread(runMethod);
        thread.start();
    }


}
