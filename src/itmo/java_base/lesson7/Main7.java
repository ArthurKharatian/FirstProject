package itmo.java_base.lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main7 {
    public static void main(String[] args) throws IOException {
//        System.out.println("Task1");
//        B test = new B();
//        test.printNumber();
//
//        System.out.println();
//        System.out.println("Task2");
//        D test2 = new D();
//        test2.getInfo();

        System.out.println();
        System.out.println("Task4");
         Plane plane = new Plane();
         Plane plane2 = new Plane();
         plane.wing.weight = 10;
         plane2.wing.weight = 20;

         plane.wing.printInfo();
         plane2.wing.printInfo();




    }
    class Car{
        public int weight;
        public String model;
        public char color;
        public float speed;

        public void outPut () {
            System.out.println("Вес " + model + " составляет " + weight + "кг.");
            System.out.println("Цвет машины - " + color + " и её скорость - " + speed);
        }

        public Car (int w, String m, char c, float s) {
            weight = w;
            model = m;
            color = c;
            speed = s;
        }

        public Car () {}

    }

    class Track extends Car{
        private int vehicles;
        private int weight;

        public void newWheels(int vehicles){
            this.vehicles = vehicles;
            System.out.println(this.vehicles);
        }

        public Track(int vehicles, int weight, String model, char color, float speed) {
            super(weight, model, color, speed);
            this.vehicles = vehicles;
            this.weight = weight;
        }
    }

    // TASK2

    static class  A{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input;
        {
            try {
                input = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static class B extends A{
        public void printNumber(){
            System.out.println(super.input);
        }
    }

    // TASK3

   static class C {
        int age;
        String name;

        public void getInfo() throws IOException {
            System.out.println(age);
        }
    }
    static class D extends C {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void getInfo() throws IOException {
            super.age = Integer.parseInt(reader.readLine());
            super.name = reader.readLine();
            super.getInfo();
            System.out.println(super.name);
        }
    }

    // TASK3-4

   public static class Plane{

        Wing wing =new Wing();
       public  class Wing{
           public  int weight;
            public void printInfo(){
                System.out.println(weight);
            }
        }
    }

}
