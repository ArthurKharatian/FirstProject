package itmo.java_base.lesson8;

public class Main8 {
    public static void main(String[] args) {
        Client client = new Client("John", "Smith");
        BankManager bankManager = new BankManager("Margot", "Robbie");
        client.printInfo();
        bankManager.printInfo();
        client.speak();
        bankManager.speak();
    }

    static abstract class Human  implements ISpeakable, IMovable{
        String name, surname;

        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public abstract void printInfo();
    }
    public static class Client extends Human{
        String bankName;
        public Client(String name, String surname) {
            super(name, surname);
            bankName = "Sberbank";
        }

        @Override
        public void printInfo() {
            System.out.println(name + " " + surname + " is a client of " + bankName);
        }

        @Override
        public void speak() {
            System.out.println("I am a client");
        }

        @Override
        public int age() {
            return 25;
        }

        @Override
        public boolean isMoving() {
            return false;
        }

        @Override
        public boolean isSeating() {
            return false;
        }
    }
   static   class BankManager extends Human{
        String bankName;
        public BankManager(String name, String surname) {
            super(name, surname);
            bankName = "Sberbank";
        }

        @Override
        public void printInfo() {
            System.out.println(name + " " + surname + " is an employee of " + bankName);
        }

       @Override
       public void speak() {
           System.out.println("I am an employee");
       }

       @Override
       public int age() {
           return 35;
       }

       @Override
       public boolean isMoving() {
           return false;
       }

       @Override
       public boolean isSeating() {
           return false;
       }
   }

    public interface ISpeakable{
        void speak();
        int age();
    }

    public interface IMovable{
        boolean isMoving ();
        boolean isSeating ();

    }
}
