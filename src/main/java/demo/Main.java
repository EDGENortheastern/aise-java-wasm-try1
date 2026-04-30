package demo; // groups classes together under a name

public class Main {

    public static String helloName(String name) {
        if (name == null || name.trim().isEmpty()){
            return "Hello World from Java 🌸";
        }
        return "Hello " + name + " from Java 🌸";
    }

    public static void main(String[] args) {
        System.out.println(helloName("You"));
    }
}
