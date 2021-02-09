package itmo.java_base.lesson6;

import java.util.Date;

public class Main6 {
    public static void main(String[] args) {
        System.out.println("Task2");
        Car car1 = new Car("Green", 1500);
        Car car2 = new Car("Red");
        car1.printInfo();
        car2.printInfo();

        System.out.println();

        System.out.println("Task3");
        House house1 = new House();
        House house2 = new House();

        house1.setValues("Tower Centre", 2007, 10);
        house2.setValues("Stalinka", 1955, 5);

        house1.printInfo();
        house2.printInfo();

        System.out.println();

        System.out.println("Task4");
        Tree tree1 = new Tree(200, "Oak");
        Tree tree2 = new Tree();
        Tree tree3 = new Tree("Sequoia", 150, true);

        System.out.println(tree2.getClass().getSimpleName());
    }
}
class Study {

    private String course;
    //TODO
    public Study(String course) {
        this.course = course;
    }
    public String printCourse() {
        return this.course;
    }
}
class JavaProgram {
    public static void main(String[] args) {
        //TODO
        Study study = new Study("Изучение Java - это просто!");
        System.out.println(study.printCourse());
    }
}

class Car{
    private String color, name;
    private int weight;

    public Car(){}

    public Car(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Car(String color) {
        this.color = color;
    }

    public  void printInfo(){
        System.out.println("Color: " + this.color);
        System.out.println("Name: " + this.name);
        System.out.println("Weight: " + this.weight);
    }
}

class House{
    private String name;
    private int year, floorCount;

    public void setValues(String name, int year, int floorCount){
        this.name = name;
        this.year = year;
        this.floorCount = floorCount;
    }

    public void printInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Year: " + this.year);
        System.out.println("Floor count: " + this.floorCount);
        System.out.println("House age: " + houseAge(this));
    }

    private static int houseAge(House house){
        Date currentDate = new Date();
        Date buildYear = new Date();
        buildYear.setYear(house.year - 1900);
        return currentDate.getYear() - buildYear.getYear();
    }
}

class Tree{
    private String name;
    private int age;
    private boolean isAlive;

    public Tree( int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Tree(String name, int age, boolean isAlive) {
        this.name = name;
        this.age = age;
        this.isAlive = isAlive;
    }

    public Tree() {
        System.out.println("Пустой конструктор без параметров сработал");
    }
}
