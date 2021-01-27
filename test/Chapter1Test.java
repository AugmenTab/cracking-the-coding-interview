import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class Chapter1Test {

  @DisplayName("Is Unique Test: Stream")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "is-unique-test.csv", numLinesToSkip = 1)
  void isUnique(String input, boolean expected) {
    assertEquals(expected, Chapter1.isUnique(input));
  }

  @DisplayName("Is Unique Test: Loop")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "is-unique-test.csv", numLinesToSkip = 1)
  void isUniqueLoop(String input, boolean expected) {
    assertEquals(expected, Chapter1.isUniqueLoop(input));
  }

  @DisplayName("Is Unique Test: Two Loops")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "is-unique-test.csv", numLinesToSkip = 1)
  void isUniqueNoAdditionalDataStructures(String input, boolean expected) {
    assertEquals(expected, Chapter1.isUniqueNoAdditionalDataStructures(input));
  }

  @DisplayName("Check Permutation")
  @ParameterizedTest(name = "[{index}]: input1 = {0}, input2 = {1}, expected = {3};")
  @CsvFileSource(resources = "check-permutation-test.csv", numLinesToSkip = 1)
  void checkPermutation(String input1, String input2, boolean expected) {
    assertEquals(expected, Chapter1.checkPermutation(input1, input2));
  }

  @DisplayName("URLify")
  @ParameterizedTest(name = "[{index}]: input = {0}, expected = {1};")
  @CsvFileSource(resources = "urlify-test.csv", numLinesToSkip = 1)
  void urlify(String input, String expected) {
    assertEquals(expected, Chapter1.urlify(input));
  }

}