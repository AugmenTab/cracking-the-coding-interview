import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class Chapter1Test {

  @DisplayName("Is Unique Test: Stream")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "ch01/is-unique-test.csv", numLinesToSkip = 1)
  void isUnique(String input, boolean expected) {
    assertEquals(expected, Chapter1.isUnique(input));
  }

  @DisplayName("Is Unique Test: Loop")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "ch01/is-unique-test.csv", numLinesToSkip = 1)
  void isUniqueLoop(String input, boolean expected) {
    assertEquals(expected, Chapter1.isUniqueLoop(input));
  }

  @DisplayName("Is Unique Test: Two Loops")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "ch01/is-unique-test.csv", numLinesToSkip = 1)
  void isUniqueNoAdditionalDataStructures(String input, boolean expected) {
    assertEquals(expected, Chapter1.isUniqueNoAdditionalDataStructures(input));
  }

  @DisplayName("Is Unique Test: Sort")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "ch01/is-unique-test.csv", numLinesToSkip = 1)
  void isUniqueSort(String input, boolean expected) {
    assertEquals(expected, Chapter1.isUniqueSort(input));
  }

  @DisplayName("Check Permutation")
  @ParameterizedTest(name = "[{index}]: input1 = {0}, input2 = {1}, expected = {3};")
  @CsvFileSource(resources = "ch01/check-permutation-test.csv", numLinesToSkip = 1)
  void checkPermutation(String input1, String input2, boolean expected) {
    assertEquals(expected, Chapter1.checkPermutation(input1, input2));
  }

  @DisplayName("URLify")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "ch01/urlify-test.csv", numLinesToSkip = 1)
  void urlify(String input, String expected) {
    assertEquals(expected, Chapter1.urlify(input));
  }

  @DisplayName("URLify w/ StringBuilder")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "ch01/urlify-test.csv", numLinesToSkip = 1)
  void urlifyBuilder(String input, String expected) {
    assertEquals(expected, Chapter1.urlifyBuilder(input));
  }

  @DisplayName("Palindrome Permutation")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1}")
  @CsvFileSource(resources = "ch01/palindrome-permutation-test.csv", numLinesToSkip = 1)
  void palindromePermutation(String input, boolean expected) {
    assertEquals(expected, Chapter1.palindromePermutation(input));
  }

  @DisplayName("One Away")
  @ParameterizedTest(name = "[{index}]: input1 = {0}, input2 = {1}, expected = {3};")
  @CsvFileSource(resources = "ch01/one-away-test.csv", numLinesToSkip = 1)
  void oneAway(String input1, String input2, boolean expected) {
    assertEquals(expected, Chapter1.oneAway(input1, input2));
  }

  @DisplayName("String Compression")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1}")
  @CsvFileSource(resources = "ch01/string-compression-test.csv", numLinesToSkip = 1)
  void stringCompression(String input, String expected) {
    assertEquals(expected, Chapter1.stringCompression(input));
  }

  // Test for 1.7

  // Test for 1.8

  @DisplayName("String Rotation")
  @ParameterizedTest(name = "[{index}]: input1 = {0}, input2 = {1}, expected = {3};")
  @CsvFileSource(resources = "ch01/string-rotation-test.csv", numLinesToSkip = 1)
  void stringRotation(String input1, String input2, boolean expected) {
    assertEquals(expected, Chapter1.stringRotation(input1, input2));
  }

}