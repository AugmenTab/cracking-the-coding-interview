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

}
