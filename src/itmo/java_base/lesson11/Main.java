package itmo.java_base.lesson11;


import java.util.ArrayList;
import java.util.List;

public class Main extends Thread {
    public Main(Runnable target) {
        super(target);
    }

    public Main() {
    }

    public static void main(String[] args) throws InterruptedException {
        runTenThreads();
    }


    private static void runTenThreads() throws InterruptedException {
         List<Main> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getState() + thread.getName());
            Main main = new Main() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getState() + thread.getName());
                    for (int j = 0; j < 100; j++) {
                        System.out.println(j);
                    }
                }
            };
            threads.add(main);
            System.out.println(main.getState() + main.getName());
            main.start();
            Main main1 = new Main(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getState() + thread.getName());
                    for (int j = 0; j < 100; j++) {
                        System.out.println(j);
                    }
                }
            });
            threads.add(main1);
            System.out.println(main1.getState() + main1.getName());
            main1.start();
            Thread thread2 = Thread.currentThread();
            System.out.println(thread2.getState() + thread2.getName());

        }
        for (Main thread : threads) {
            thread.join();

        }
        for (Main thread : threads) {
            System.out.println(thread.getState() + " " + thread.getName());
        }
    }
}
