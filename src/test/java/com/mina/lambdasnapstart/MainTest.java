package com.mina.lambdasnapstart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainTest {

  @Autowired
  private Main main;

  @Test
  void testToUpperCase() {
    var toUpperCase = main.toUpperCase();

    assertEquals("HELLO", toUpperCase.apply("hello"));
    assertEquals("WORLD", toUpperCase.apply("world"));
    assertEquals("123", toUpperCase.apply("123"));
    assertEquals("", toUpperCase.apply(""));
    assertNull(toUpperCase.apply(null));
  }

  @Test
  void testIsPalindrome() {
    var isPalindrome = main.isPalindrome();

    assertTrue(isPalindrome.apply("level"));
    assertTrue(isPalindrome.apply("deified"));
    assertTrue(isPalindrome.apply("radar"));
    assertTrue(isPalindrome.apply("A man, a plan, a canal: Panama"));
    assertTrue(isPalindrome.apply("Able , was I saw eLba")); // Case-insensitive and ignoring non-alphanumeric characters
    assertTrue(isPalindrome.apply("No lemon, no melon")); // Not a palindrome
    assertTrue(isPalindrome.apply("12321"));
    assertFalse(isPalindrome.apply("hello"));
    assertFalse(isPalindrome.apply(null));
  }
}