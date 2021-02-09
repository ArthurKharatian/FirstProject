package itmo.java_base.lesson4;


public class Main4 {
    public static void main(String[] args) {
        System.out.println("Task1");
         compareLengths("Privet", "kak", "dela");
         compareLengths("Da", "vse", "horosho");
         compareLengths("Da", "da", "ne");


        System.out.println();
        System.out.println("Task2");
        System.out.println(isPalindrome("ТОПОТ"));
        System.out.println(isPalindrome("Hello"));

        System.out.println();
        System.out.println("Task3");
        System.out.println(changeBadWord("Ты настолько плохая бяка, что мне нужна другая бяка"));


        System.out.println();
        System.out.println("Task4");
        System.out.println(count("test", "i did test for test and it was only test for test"));


        System.out.println();
        System.out.println("Task5");
        System.out.println(reverse("Hello world!"));


    }

    public static void compareLengths(String s, String str, String string){
        int a = s.length();
        int b = str.length();
        int c = string.length();

        if(a == b && b == c){
            System.out.println("everyone is equal");
        }
        else {
            if (a >= b && a >= c) {
                System.out.println(s + " is the longest");
            } else if (b >= a && b >= c) {
                System.out.println(str + " is the longest");
            } else {
                System.out.println(string + " is the longest");
            }
        }
    }

    public static boolean isPalindrome(String s) {
        return s.replaceAll("\\W","").equalsIgnoreCase(new StringBuilder(s.replaceAll("\\W","")).reverse().toString());
    }

    public static String changeBadWord(String s){
        String[] text = s.split(" ");
        String badWord = "бяка";
        String result = "";
        for (String string : text){
            if(string.equalsIgnoreCase(badWord)){
              result =  s.replaceAll(badWord, "[вырезано цензурой]");
            }
        }
        return result;
    }

    public static int count(String s, String str){
         String[] text = str.split(" ");
         int count = 0;
         for(String string : text){
             if(s.equalsIgnoreCase(string))
                 count++;
         }
        return count;
    }

    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

}
