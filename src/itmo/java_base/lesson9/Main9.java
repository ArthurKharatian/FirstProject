package itmo.java_base.lesson9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main9 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        int[][] array = new int[][]{{14, 2,24},{50, 1, 15}};
        findMaxElement(array);

        System.out.println();
        System.out.println("Task 2");
        int[][] square = new int[][]{{4, 2, 3},{4, 5, 6}, {3, 5, 6}};
        isSquare(square);
        isSquare(array);


        System.out.println();
        System.out.println("Task 3");
        findLongestString(square);
        findLongestString(array);

        System.out.println();
        System.out.println("Task 4");
        fillMatrix();

        System.out.println();
        System.out.println("Task 5");
        int[] arr1 = new int[]{3,3,3};
        int[] arr2 = new int[]{4,5,3};
        findNumInArray(arr1, arr2);

    }

    public static void findMaxElement(int[][] array){
        if(array == null || array.length == 0)
            throw new IllegalArgumentException();
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length - 1; j++) {
                if(array[i][j] > array[j][i])
                    max = array[i][j];
            }
        }
        System.out.println(max);
    }

    public static void isSquare(int[][] array) {
        if (array[0].length == array.length)
            System.out.println("The matrix is square");
        else System.out.println("The matrix is rectangle");
    }

    public static void findLongestString(int[][] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException();
        }
           int maxString = 0;
           int sum = 0;
           int position = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length - 1; j++) {
                sum += array[i][j];
            }
            if(sum >maxString){
                maxString = sum;
                position = i;
            }
        }
        System.out.println("Max is " + maxString + " on position " + position);

    }

    public static void fillMatrix() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[][] matrix = null;
        try {
            matrix = new char[Integer.parseInt(reader.readLine())][Integer.parseInt(reader.readLine())];
         }catch (NullPointerException e){
            System.out.println("The matrix is not created");
         }  catch (NumberFormatException e){
            System.out.println("Not a number");
        }catch (IOException e){
            System.out.println("Wrong data");
        }catch (Exception e){
            System.out.println("Other exception");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {

                matrix[i][j] = (char) (new Random().nextInt(26) + 'a');
            }
        }
        for(char[]arr : matrix){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void findNumInArray(int[] numbers, int[] weight){

        int findNum = numbers[(int)(Math.random() * numbers.length - 1)];

        for (int i = 0; i < weight.length; i++) {
            if(weight[i] == findNum){
                System.out.println("The index of " + findNum + " is " + i);
            }
        }
    }
}
