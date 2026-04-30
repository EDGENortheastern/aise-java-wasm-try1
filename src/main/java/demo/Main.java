package demo;

import org.teavm.jso.JSExport;

public class Main {

    @JSExport
    public static String helloName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello World from Java 🌸";
        }
        return "Hello " + name + " from Java 🌸";
    }

    public static void main(String[] args) {
        System.out.println(helloName("You"));
    }
}