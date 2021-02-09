package itmo.java_base.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) throws IOException {
//        System.out.println("Task1: ");
//        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr2 = {5, 2, 3, 4, 5};
//        printOK(arr);
//        printOK(arr2);
//
//        System.out.println();
//        System.out.println("Task2");
//        createArray();
//
//        System.out.println();
//        System.out.println("Task3");
//        switchElements(arr);
//
//        System.out.println();
//        System.out.println("Task4");
//        printUniqueNum(arr2);
//
//        System.out.println();
//        System.out.println("Task5");
//        printFibonacciNum();
//
//
//        System.out.println();
//        System.out.println("Task6");
//        int[] nums = createArray();
//        int[] sorted = mergeSort(nums);
//        System.out.println(Arrays.toString(sorted));


        System.out.println();
        System.out.println("Task7");
        int[] array = {2, 3, 1, 2, 2, 2, 4, 5, 3, 3, 3, 5, 3, 3, 5, 5, 6, 6, 6, 7, 7, 2, 2, 5, 5};
        findElement(array, 2);


    }

    public static void printOK(int[] array){
        boolean flag = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("OK");
        else System.out.println("Please, try another numbers");
    }

    public static int[] createArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        return nums;
    }

    public static void switchElements(int[] array){
        System.out.println(Arrays.toString(array));
        int a = array[0];
        int b = array[array.length - 1];

        array[0] = b;
        array[array.length - 1] = a;
        System.out.println(Arrays.toString(array));
    }
    public static void printUniqueNum(int[] array){
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if(array[i] == array[j] && i != j){
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.print(array[i] + " ");
        }
        System.out.println();
    }

   public static void printFibonacciNum() throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter number ->");
       int n = Integer.parseInt(reader.readLine());

       long x = Math.round((1/Math.sqrt(5)) * (Math.pow(((1 + Math.sqrt(5))/2), n) - Math.pow(((1 - Math.sqrt(5))/2), n))) ;
       System.out.println(x);
   }

   public static int[] mergeSort(int[] array) throws IOException {
       System.out.println(Arrays.toString(array));
        if(array.length < 2){
            return array;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right;
        if(array.length % 2 == 0)
             right = new int[mid];
        else right = new int[mid + 1];

       for (int i = 0; i < mid; i++) {
            left[i] = array[i];
       }
       for (int j = 0; j < right.length; j++) {
            right[j] = array[mid + j];
       }
       int[] result = new int[array.length];
       left = mergeSort(left);
       right = mergeSort(right);
       result = mergeParts(left, right);
       return result;
   }

    private static int[] mergeParts(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        while (leftPointer < left.length || rightPointer < right.length){
            if(leftPointer < left.length && rightPointer < right.length){
                if(left[leftPointer] < right[rightPointer])
                    result[resultPointer++] = left[leftPointer++];
                else result[resultPointer++] = right[rightPointer++];
            }
            else if(leftPointer < left.length)
                result[resultPointer++] = left[leftPointer++];
            else  if(rightPointer < right.length)
                result[resultPointer++] = right[rightPointer++];
        }
        return result;
    }


    public static void findElement(int[] array, int k){

        int[] counter = new int[10];

        for (int i = 0; i < array.length; i++) {
            counter[array[i]]++;
        }

        for (int i = 0; i < counter.length; i++) {
            if(counter[i] == k)
            System.out.println("number " + i + " repeats " + counter[i] + " times");
        }
    }
}
