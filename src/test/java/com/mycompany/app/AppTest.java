package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CalculatorTest {

    // Code Smell: Unused import
    private ArrayList<String> list = new ArrayList<>(); // Unused variable

    @Test
    public void testDivideByZero() {
        RealWorldExample example = new RealWorldExample();

        try {
            example.main(new String[]{}); // This will trigger divide by zero in the main method
            fail("Expected ArithmeticException"); // Bug: This will never be reached
        } catch (ArithmeticException e) {
            // Exception is expected, test passes
        }
    }

    @Test
    public void testNullPointer() {
        RealWorldExample example = new RealWorldExample();

        try {
            example.main(new String[]{}); // This will trigger a NullPointerException in the main method
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Exception is expected, test passes
        }
    }

    // Code Smell: Too many assertions in one test
    @Test
    public void testMultipleAssertions() {
        RealWorldExample example = new RealWorldExample();

        // Code Smell: Multiple assertions in a single test, makes it harder to debug
        assertEquals(10, 5 + 5);
        assertTrue(10 > 5);
        assertNotNull(example);
        assertFalse("This is a bug!".equals("Hello")); // Intentionally incorrect assertion for practice
    }

    @Test
    public void testHardcodedCredentials() {
        // Vulnerability: Hardcoded credentials (detected by SonarQube)
        String username = "admin"; // Vulnerability: Hardcoded credentials
        String password = "password123"; // Vulnerability: Hardcoded credentials

        assertEquals("admin", username);
        assertEquals("password123", password);
    }

    @Test
    public void testProcessDataTooManyParams() {
        RealWorldExample.processData("John", "Doe", 35, "john.doe@example.com", "12345", "California", "USA", "123-456-7890");
    }

    @Test
    public void testComplexMethod() {
        RealWorldExample.complexMethod(); // Code Smell: Method is too large, detected by SonarQube
    }

    // Duplicated code in the test (for demonstration)
    @Test
    public void testDuplicatedCode() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{4, 5, 6};

        // Code Smell: Duplicated code, both arrays are being initialized in the same way
        for (int i : arr1) {
            System.out.println(i);
        }

        for (int i : arr2) {
            System.out.println(i); // Identical logic, should be refactored into a method
        }
    }
}

