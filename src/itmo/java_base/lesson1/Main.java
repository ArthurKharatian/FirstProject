package itmo.java_base.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Я");
        System.out.println("хорошо");
        System.out.println("знаю");
        System.out.println("Java.");


        System.out.println((46 + 10) * (10.0/3));
        System.out.println(29 * 4 * (-15));

        int number = 10500;
        int result = (number/10)/10;
        System.out.println(result);

        double a = 3.6, b = 4.1, c = 5.9;
        double result2 = a * b * c;
        System.out.println(result2);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter numbers->");
        int i = Integer.parseInt(reader.readLine());
        int j = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

        int x = Integer.parseInt(reader.readLine());

        if(x % 2 != 0){
            System.out.println("нечетное");
        }else {
            System.out.println("четное");
            if(x > 100)
                System.out.println("Выход за пределы диапазона");
        }

    }

}
