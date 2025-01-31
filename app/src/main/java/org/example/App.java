package org.example;

import java.util.Scanner;

public class App {
  public int getInput(String prompt, String errorMessage, int lowerBound, int upperBound, String defaultPrompt, int defaultValue, String exitPrompt) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println(prompt);

      if (defaultPrompt != null && !defaultPrompt.isEmpty()) {
        System.out.println(defaultPrompt + " (Default: " + defaultValue + ")");
      }
      if (exitPrompt != null && !exitPrompt.isEmpty()) {
        System.out.println(exitPrompt);
      }

      String input = scanner.nextLine().trim();

      if (exitPrompt != null && input.equalsIgnoreCase("exit")) {
        System.out.println("Exiting the program...");
        return Integer.MIN_VALUE;
      }

      if (defaultPrompt != null && input.equalsIgnoreCase("default")) {
        return defaultValue;
      }

      try {
        int value = Integer.parseInt(input);
        if (value >= lowerBound && value <= upperBound) {
          return value;
        } else {
          System.out.println(errorMessage);
        }
      } catch (NumberFormatException e) {
        System.out.println(errorMessage);
      }
    }
  }

  public static void main(String[] args) {
    App app = new App();

    int result = app.getInput(
      "Please enter a number between 25 and 150:",
      "Invalid input. Please enter a valid number between 25 and 150.",
      25,
      150,
      "Type 'default' to use the default value.",
      100,
      "Type 'exit' to quit."
    );

    if (result == Integer.MIN_VALUE) {
      System.out.println("User chose to exit. Goodbye!");
    } else {
      System.out.println("The value chosen by the user is: " + result);
    }
  }
}