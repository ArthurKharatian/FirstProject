package itmo.java_base.lesson12;


import java.io.*;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Task 1");
//        List<String> text = text(new File("C:/test/text2.txt"));
//        for (String s : text) {
//            System.out.print(s + " ");
//        }
//
//
//        System.out.println();
//        System.out.println("Task 2");
//        writeData(text);
//        System.out.println("It's done =)");
////
//        System.out.println();
//        System.out.println("Task 3");
//        mergeText(new File("C:/test/text2.txt"), new File("C:/test/text3.txt"));
//        searchFiles("C:/test/", "text");
        searchFiles2("C:/test/", "Kak");

    }

    public static List<String> text(File file) {
        List<String> text = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {

                String[] split = line.split(" ");
                Collections.addAll(text, split);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    // FileWriter writer = new FileWriter("C:/test/text.txt")
    public static void writeData(List<String> text) {
        StringBuilder builder = new StringBuilder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/test/text.txt"))) {
            for (String s : text) {

                builder.append(s).append(" ");

            }
            writer.write(builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mergeText(File file, File file2) throws IOException {
        List<String> text1 = text(file);
        List<String> text2 = text(file2);
        List<String> allText = new ArrayList<>();
        allText.addAll(text1);
        allText.addAll(text2);

        writeData(allText);

    }

    public static void copyFile(File file, File file2) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file2);

        while (inputStream.available() > 0) {
            outputStream.write(inputStream.read());
        }

        inputStream.close();
        outputStream.close();
    }

    public static void searchFiles(String directory, String word) throws IOException {
        Path  path = Paths.get(directory);
        List<String> fileNames = new ArrayList<>();
        for (File item : path.toFile().listFiles()) {
            if(item.getName().contains(word)){
                System.out.println(item.getName());
            };
        }

    }

    public static void searchFiles2(String directory, String word) throws IOException {
        Path  path = Paths.get(directory);

        for (File item : path.toFile().listFiles()) {
            List<String> itemText = text(item);
            for (String s : itemText){
                if(s.equals(word)){
                    System.out.println(item.getName());
                }
            }
        }


    }

}
