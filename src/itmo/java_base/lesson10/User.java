package itmo.java_base.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public  class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        getScore();
    }

    public static void getScore() throws IOException {
        Map<User, Integer> map = new HashMap<>();
        map.put(new User("Andrew"), 200);
        map.put(new User("Mike"), 500);
        map.put(new User("John"), 300);
        map.put(new User("Carl"), 100);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

//
//        for (User user : map.keySet()) {
//            String userName = user.getName();
//            if (userName.equals(name))
//                System.out.println(userName + " " + map.get(user));
//        }
        for(Map.Entry<User, Integer> pair : map.entrySet()){
            User user = pair.getKey();
            int score = 0;
            if(user.getName().equals(name)) {
                score = map.get(user);
                System.out.println(user.getName() + "'s score is " + score);
            }
        }


    }
}