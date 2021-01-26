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

}