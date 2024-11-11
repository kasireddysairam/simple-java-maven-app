package com.example;

import java.util.HashMap;
import java.util.Map;

public class RealWorldExample {

    // Code smell: Unused variable
    private static final String CONSTANT_VALUE = "UnusedConstant"; // Unused variable

    public static void main(String[] args) {

        // Code smell: Empty catch block (ignored exception)
        try {
            int result = 10 / 0; // Bug: Divide by zero
        } catch (ArithmeticException e) {
            // Do nothing, should not ignore exception
        }

        // Bug: Null pointer dereference
        String value = null;
        if (value.length() > 0) { // Null pointer exception
            System.out.println(value);
        }

        // Vulnerability: Hardcoded credentials
        String username = "admin"; // Vulnerability: Hardcoded credentials
        String password = "password123"; // Vulnerability: Hardcoded credentials

        // Code Smell: Too many parameters
        processData("John", "Doe", 35, "john.doe@example.com", "12345", "California", "USA", "123-456-7890");

        // Code Smell: Method with too many lines
        complexMethod();

        // Duplicated code: Identical code in two places
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");

        Map<String, String> map2 = new HashMap<>();
        map2.put("key2", "value2"); // Identical code to map1

    }

    // Code Smell: Too many lines of code
    private static void complexMethod() {
        String a = "Hello";
        String b = "World";
        String c = "This";
        String d = "is";
        String e = "a";
        String f = "complex";
        String g = "method";
        String h = "with";
        String i = "too";
        String j = "many";
        String k = "lines";

        // Excessive code for no reason
        String result = a + b + c + d + e + f + g + h + i + j + k;

        System.out.println(result);
    }

    // Code Smell: Too many parameters in method signature
    public static void processData(String firstName, String lastName, int age, String email,
                                   String id, String state, String country, String phone) {
        System.out.println("Processing data...");
    }
}
