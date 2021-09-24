package javadeepdown;

public class ThreadingDemo extends Thread {

    public int sum;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++)
            sum += 1;
    }

    public static void main(String[] args) {
        ThreadingDemo threadingDemo = new ThreadingDemo();
        ThreadingDemo threadingDemo2 = new ThreadingDemo();
        threadingDemo.start();
        threadingDemo2.start();
        System.out.println(threadingDemo.sum);
    }

}
