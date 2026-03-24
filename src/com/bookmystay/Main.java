package com.bookmystay;

/**
 * UC1 - Application Entry Point
 *
 * Goal: Establish a clear and predictable starting point for the Hotel Booking
 * application by demonstrating how a Java program begins execution and produces
 * console output.
 *
 * Flow:
 *  1. User runs the application.
 *  2. JVM invokes the main() method — the single entry point of every Java program.
 *  3. Application prints a welcome message with the application name and version.
 *  4. Application terminates normally.
 *
 * Key Concepts: JVM lifecycle, main() method signature, System.out.println
 */
public class Main {

    private static final String APP_NAME = "BookMyStay Hotel Management System";
    private static final String VERSION  = "1.0.0";

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Welcome to " + APP_NAME);
        System.out.println("  Version: " + VERSION);
        System.out.println("========================================");
        System.out.println("Application started successfully.");
        System.out.println("Application terminated.");
    }
}
