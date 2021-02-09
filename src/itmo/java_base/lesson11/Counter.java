package itmo.java_base.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Counter extends Thread{

    public static void main(String[] args) {
      runThreads();

    }
    int count = 0;
    public synchronized void increment(){
        count++;
    }

    public  int getCount() {
        return count;
    }


    private static void runThreads() {
        int count = 0;
        List<Counter> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Counter counter = new Counter(){
                @Override
                public synchronized void run(){
                    for (int j = 0; j < 1000; j++) {
                        increment();
                    }

                }
            };

            threads.add(counter);
            counter.start();
        }
        for (Counter thread : threads) {
            System.out.println(count += thread.getCount());
        }
    }


}
