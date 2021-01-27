import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Chapter1 {

  private Chapter1() {
  }

  public static boolean isUnique(String input) {
    Set<Character> checkSet = input.chars().mapToObj((e) -> (char) e).collect(Collectors.toSet());
    return checkSet.size() == input.length();
  }

  public static boolean isUniqueLoop(String input) {
    char[] data = input.toCharArray();
    Set<Character> checkSet = new HashSet<>();
    for (char datum : data) {
      if (!checkSet.add(datum)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isUniqueNoAdditionalDataStructures(String input) {
    char[] data = input.toCharArray();
    for (int i = 0; i < data.length - 1; i++) {
      for (int j = i + 1; j < data.length; j++) {
        if (data[i] == data[j]) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean checkPermutation(String input1, String input2) {
    char[] sorted1 = input1.toCharArray();
    char[] sorted2 = input2.toCharArray();
    Arrays.sort(sorted1);
    Arrays.sort(sorted2);
    return Arrays.equals(sorted1, sorted2);
  }

  public static String urlify(String input) {
    char[] data = input.toCharArray();
    for (int i = 0; i < data.length; i++) {
      if (data[i] == ' ') {
        for (int j = data.length - 1; j > i + 2; j-= 2) {
          data[j] = data[j - 2];
          data [j - 1] = data[j - 3];
        }
        data[i] = '%';
        data[i + 1] = '2';
        data[i + 2] = '0';
        i += 2;
      }
    }
    return new String(data);
  }

}
