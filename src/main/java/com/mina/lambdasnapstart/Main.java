package com.mina.lambdasnapstart;

import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public Function<String, String> toUpperCase() {
    return value -> value != null ? value.toUpperCase() : null;
  }

  @Bean
  public Function<String, Boolean> isPalindrome() {

    /*
      Checks if the given string is a palindrome.
      A palindrome is a word, phrase, number, or sequence of characters that reads the same forward and backward.
      Examples include "level," "radar," "12321," and "madam."

      @param input The string to be checked for palindrome.
      @return True if the string is a palindrome, false otherwise.
     */
    return input -> {
      if (input == null) {
        return false;
      }
      // Remove non-alphanumeric characters and spaces
      String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
      String reversed = new StringBuilder(cleanedInput).reverse().toString();
      return cleanedInput.equalsIgnoreCase(reversed);
    };
  }
}
