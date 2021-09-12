package javadeepdown;

public class ThreadingDemo extends Thread {

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreadingDemo threadingDemo = new ThreadingDemo();
        threadingDemo.start();
        threadingDemo.start();
        threadingDemo.start();
    }

}
