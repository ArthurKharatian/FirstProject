package itmo.java_base.lesson10;

import java.io.IOException;
import java.util.*;

public class Main10 {
    public static void main(String[] args) throws IOException  {
        System.out.println("Task 1");
//        List<Integer> list = new ArrayList<>();
//        list.add(123);
//        list.add(123);
//        list.add(123);
//        list.add(321);
//        list.add(321);
//        list.add(321);
//        list.add(55555);
//        list.add(55555);
//        getOriginals(list);
//
//
//        System.out.println();
//        System.out.println("Task 2");
//        List<Integer> integers = new ArrayList<>();
//        List<Integer> integers2 = new LinkedList<>();
//        addMillion(integers);
//        addMillion(integers2);
//        randomNumber(integers);
//        randomNumber(integers2);


        System.out.println();
        System.out.println("Task 3");

        System.out.println("Task 5");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10,11,12};
        Integer[][] array2 = {{1}, {2,3,4,5,},{6,7},{8,9,10,11,12,}};

        ArrayIterator<Integer> integers = new ArrayIterator<>(array);
        ArrayIterator<Integer> integers2 = new ArrayIterator<>(array2);

        Iterator<Integer> iterator1 = integers.iterator();
        Iterator<Integer> iterator2 = integers2.iterator();

        //One-dimensional array
        System.out.println("One-dimensional array: ");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + ", ");
        }
        System.out.println();
        //Two-dimensional array
        System.out.println("Two-dimensional array: ");
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + ", ");
        }





        System.out.println();
        System.out.println("Task 7");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Sasha");
        map.put(2, "Sasha");
        map.put(3, "Misha");
        map.put(4, "Misha");
        map.put(5, "Kolya");
        map.put(6, "Kolya");
        Map<String, List<Integer>> result = mapToMap2(map);
        System.out.println(result);


    }




    public static void getOriginals(Collection<Integer> integers) {
        Set<Integer> tempIntegers = new HashSet<>(integers);
        System.out.println(tempIntegers);
    }

    public static void addMillion(Collection<Integer> integers) {
        for (int i = 0; i < 1000000; i++) {
            integers.add(i);
        }
    }

    public static void randomNumber(List<Integer> integers) {
        Date start = new Date();
        int x = 0;
        for (int i = 1; i <= 100000; i++) {
            x = integers.get((int) (Math.random() * i));
        }
        Date end = new Date();
        System.out.println(integers.getClass().getSimpleName() + " " + (end.getTime() - start.getTime()) + " ms");
    }
// Task 5







// Task 6
    public static <K> Map<K, Integer> arrayToMap (K[] ks){
        Map<K, Integer> map = new HashMap<>();
        for (int i = 0; i < ks.length; i++) {
            map.put(ks[i], i);
        }
        return map;
    }


//Task 7
    public static <K, V> Map<V, List<K>> mapToMap(Map<K, V> map){
        Map<V, List<K>> finalMap = new HashMap<>();

        for(Map.Entry<K, V> pair : map.entrySet()){
            K key = pair.getKey();
            V value = pair.getValue();
            List<K> keys = new ArrayList<>();
            if(finalMap.containsKey(value)){
                 keys = finalMap.get(value);
            }
            keys.add(key);
            finalMap.put(value, keys);
        }

        return finalMap;
    }




//For the test
    public static  Map<String, List<Integer>> mapToMap2(Map<Integer, String> map){
        Map<String, List<Integer>> finalMap = new HashMap<>();

       for(Map.Entry<Integer, String> pair : map.entrySet()){
           Integer key = pair.getKey();
           String value = pair.getValue();
           List<Integer> keys = new ArrayList<>();

           if(finalMap.containsKey(value)){
               keys = finalMap.get(value);
           }
           keys.add(key);
           finalMap.put(value, keys);
       }
        return finalMap;
    }

}
