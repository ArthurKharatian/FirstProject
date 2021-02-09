package itmo.java_base.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        printTask(1);
        doTask1();

        printTask(2);
        doTask2();

        printTask(3);
        System.out.println(doTask3());

        printTask(4);
        System.out.println(doTask4());

        printTask(5);
        int[] array5 = {3, -3, 7, 4, 5, 4, 3};
        System.out.println("array = " + Arrays.toString(array5));
        System.out.println(doTask5(array5));

        printTask(6);
        int[] array6 = {3, -3, 7, 4, 5, 4, 3};
        System.out.println(doTask6(array6));

    }
    public  static  void doTask1(){
        for (int i = 1; i <= 99 ; i++) {
            if(i % 2 != 0)
                System.out.println(i);
        }
    }
    public static void doTask2(){
        List<Integer> integers3 = new ArrayList<>();
        List<Integer> integers5 = new ArrayList<>();
        List<Integer> integers35 = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            if(i % 3 == 0) {
                integers3.add(i);
            }
            if(i % 5 == 0) {
                integers5.add(i);
            }
            if(i % 3 == 0 && i % 5 == 0) {
                integers35.add(i);
            }

        }
        System.out.println("Делится на 3: " + integers3);
        System.out.println("Делится на 5: " + integers5);
        System.out.println("Делится на 3 и на 5: " + integers35);
    }

    public static boolean doTask3() throws IOException {

        System.out.println("Введите первое число: ");
        int a = Integer.parseInt(reader.readLine());
        System.out.println("Введите второе число: ");
        int b = Integer.parseInt(reader.readLine());
        System.out.println("Введите третье число: ");
        int c = Integer.parseInt(reader.readLine());

        return b > a && c > b;
    }
    public static boolean doTask4() throws IOException {

        System.out.println("Введите первое число: ");
        int a = Integer.parseInt(reader.readLine());
        System.out.println("Введите второе число: ");
        int b = Integer.parseInt(reader.readLine());
        System.out.println("Введите третье число: ");
        int c = Integer.parseInt(reader.readLine());

        return (a + b) == c;
    }

    public static boolean doTask5(int[] array){
        if(array.length >= 2) {
            return array[0] == 3 && array[array.length - 1] == 3;
        }
        return false;
    }
    public static boolean doTask6(int[] array){
       for(int i : array){
           if(i == 1 || i == 3){
              return true;
           }
       }
       return false;
    }
    public static void printTask(int x){
        System.out.println("Task " + x + ": ");
    }
}
