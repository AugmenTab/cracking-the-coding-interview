import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Chapter1 {

  private Chapter1() {
  }

  /* 1.1: "Implement an algorithm to determine if a string has all unique characters." Turned the
  * input string into a stream of chars and added them to a set, then checked to see if the set's
  * size was the same as the length of the string. If they are equal, then the string is unique. */
  public static boolean isUnique(String input) {
    Set<Character> checkSet = input.chars().mapToObj((e) -> (char) e).collect(Collectors.toSet());
    return checkSet.size() == input.length();
  }

  /* 1.1: "Implement an algorithm to determine if a string has all unique characters." Turned the
  * input into an array of chars, then looped over it and added each to a set. If at any point the
  * set.add method returns false, it means the character was already in the set, and thus the
  * string is not unique. */
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

  /* 1.1: "Implement an algorithm to determine if a string has all unique characters. What if you
  * cannot use additional data structures?" Focusing on the second part of the problem. This method
  * turns the string into an array of chars, then does a O(x^2) loop. For each item in the array, it
  * checks each item after it to determine if they match. If at any point the items are equal, it
  * returns false. */
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

  /* 1.2: "Given two strings, write a method to decide if one is a permutation of the other." For
  * this problem, I converted each string into an array of chars, then sorted them both. The method
  * returns whether a comparison between the two sorted arrays determines if they are equal. */
  public static boolean checkPermutation(String input1, String input2) {
    char[] sorted1 = input1.toCharArray();
    char[] sorted2 = input2.toCharArray();
    Arrays.sort(sorted1);
    Arrays.sort(sorted2);
    return Arrays.equals(sorted1, sorted2);
  }

  /* 1.3: "Write a method to replace all spaces in a string with '%20.' You may assume that the
  * string has sufficient space at the end to hold the additional characters, and that you are given
  * the 'true' length of the string." I started by turning the string into an array of chars and
  * creating a loop to check each element for the char ' '. Upon finding one, I shifted the array to
  * the right two spaces, then added the '%20' chars in their appropriate places. Then, I continued
  * the loop from what was originally the next element prior to the shift. Once complete, I returned
  * the modified array as a new string. */
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

  public static boolean palindromePermutation(String input) {
    return false;
  }

  /* 1.5: "Given two strings, write a function to check if they are one edit (or zero edits) away."
  * This one was just a matter of taking each character in the first string and replacing its first
  * occurrence in the second string with nothing. If at the end, the length of the modified string
  * was 2 or more, it was more than one edit away. */
  public static boolean oneAway(String input1, String input2) {
    for (int i = 0; i < input1.length(); i++) {
      String snip = input1.substring(i, i + 1);
      input2 = input2.replaceFirst(snip, "");
    }
    return (input2.length() < 2);
  }

}
