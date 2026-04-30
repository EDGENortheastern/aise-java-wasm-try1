package demo;

import org.teavm.jso.JSExport;

public class Main {

    // This string proves the greeting is built in Java, not JavaScript
    private static final String JAVA_VIBES = "☕🚀✨🎉🌺";

    @JSExport
    public static String helloName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return JAVA_VIBES + " Hello World — built in Java! " + JAVA_VIBES;
        }
        return JAVA_VIBES + " Hello " + name + " — built in Java! " + JAVA_VIBES;
    }

    public static void main(String[] args) {
        System.out.println(helloName("You"));
    }
}