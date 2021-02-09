package itmo.java_base.lesson12;

import java.io.File;

import java.util.ArrayList;
import java.util.function.Function;

public class Task7 {
    public static void main(String[] args) {

// ПОИСК ФАЛОВ, В ИМЕНИ КОТОРЫХ ВСТРЕЧАЕТСЯ СЛОВО IMAGE

        Function<File, ArrayList<String>> searchImage = file -> {
            ArrayList<String> imageFiles = new ArrayList<>();

                if(file.getName().contains("image"))
                    imageFiles.add(file.getName());

            System.out.println(imageFiles);
            return imageFiles;
        };

// ПОИСК ФАЛОВ, КОТОРЫЕ МЕНЬШЕ 1МВ

        Function<File, ArrayList<String>> search1MBLess = file -> {
            ArrayList<String> imageFiles = new ArrayList<>();

            if(file.length() < 1000000L)
                imageFiles.add(file.getName());

            System.out.println(imageFiles);
            return imageFiles;
        };

        File[] files = new File("C:/Users/Артур/Downloads/Telegram Desktop").listFiles();

        System.out.println("Show image files");
        for(File file : files) {
            searchImage.apply(file);
        }

        System.out.println("Show 1MB less files");
        for(File file : files) {
            search1MBLess.apply(file);
        }

    }

}
