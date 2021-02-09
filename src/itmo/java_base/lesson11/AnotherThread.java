package itmo.java_base.lesson11;

public class AnotherThread extends Thread{
    String name = " AnotherThread";
    private Object object;
    public AnotherThread(Object object){
        this.object = object;
    }

    public static void main(String[] args) {
//        Object object = new Object();
//        AnotherThread anotherThread = new AnotherThread(object);
//        AnotherThread anotherThread2 = new AnotherThread(object);
//
//        anotherThread.start();
//        anotherThread2.start();

    }
    @Override
    public void run(){
        while (true){
            synchronized (object){
                System.out.println(name);
                try {
                    object.notify();
                    object.wait();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
