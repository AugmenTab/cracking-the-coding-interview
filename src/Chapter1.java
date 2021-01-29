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

  /* 1.1: "Implement an algorithm to determine if a string has all unique characters. What if you
   * cannot use additional data structures?" Focusing on the second part of the problem. This is an
   * even simpler solution than the previous implementation. Rather than a second loop, this version
   * sorts the array first, then checks if the current item is the same as the previous item, and if
   * it is at any point, it returns false. */
  public static boolean isUniqueSort(String input) {
    char[] data = input.toCharArray();
    Arrays.sort(data);
    for (int i = 0; i < data.length - 1; i++) {
      if (data[i] == data[i + 1]) {
        return false;
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
  * the modified array as a new string. I would have used a StringBuilder, but the instructions
   * included an additional directive to use a char array and perform the operation in-place if
   * doing these practice problems in Java. I have added the StringBuilder solution below. */
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

  /* 1.3: "Write a method to replace all spaces in a string with '%20.' You may assume that the
  * string has sufficient space at the end to hold the additional characters, and that you are given
  * the 'true' length of the string." For this version of the method, I stripped any whitespace off
  * the end of the turned the string into an array of chars again, then made a StringBuilder as
  * large as the original input string's length, since I know that we can assume the input string
  * will contain the necessary number of characters. I then looped over the char array and used a
  * ternary to append either the char or '%20' to the StringBuilder instead of doing the operation
  * in-place on the char array. I find that this one is easier to understand on first viewing than
  * the other version. */
  public static String urlifyBuilder(String input) {
    char[] data = input.replaceFirst("\\s++$", "").toCharArray();
    StringBuilder result = new StringBuilder(input.length());
    for (char c : data) {
      result.append(c == ' ' ? "%20" : c);
    }
    return result.toString();
  }

  /* 1.4: "Given a string, write a function to check if it is a permutation of a palindrome. The
  * palindrome does not need to be limited to just dictionary words." In order to be considered a
  * palindrome, the string can have a maximum of 1 character that appears an odd number of times.
  * So, I opted to approach this one by keeping track of how many characters appear an odd number of
  * times in the input string. I do this with a set - for each char in the array, I attempt to
  * remove it from the set. If it cannot be removed, then I add it. At the end, if the set has more
  * than 1 item in it, the string must have more than one char appearing an odd number of times, so
  * it cannot be a permutation of a palindrome. */
  public static boolean palindromePermutation(String input) {
    Set<Character> odds = new HashSet<>();
    char[] data = input.replaceAll("\\s", "").toLowerCase().toCharArray();
    for (char c : data) {
      if (!odds.remove(c)) {
        odds.add(c);
      }
    }
    return odds.size() <= 1;
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

  /* 1.6: "Implement a method to perform basic string compression using the counts of repeated
  * characters. For example, the string aabcccccaaa would become a2b1c5a3. If the compressed string
  * would not become smaller than the original string, your method should return the original
  * string. You can assume the string has only uppercase and lowercase letters." I started by
  * turning the input string into a char array and creating a new StringBuilder. I looped over the
  * char array, keeping track of the last char and the number of times that char has appeared in a
  * row. If the current element in the array is the equal to the last item, it increments the count.
  * Otherwise, it appends the last character and its counter to the StringBuilder and starts over
  * counting with the new character. At the end, it appends the final character and count, then
  * compares the length of the new string to the original, returning the shorter of the two. */
  public static String stringCompression(String input) {
    char[] data = input.toCharArray();
    StringBuilder result = new StringBuilder(input.length());
    char last = data[0];
    int count = 0;
    for (char c : data) {
      if (c == last) {
        count++;
      } else {
        result.append(last).append(count);
        last = c;
        count = 1;
      }
    }
    String compressed = result.append(last).append(count).toString();
    return (compressed.length() > input.length()) ? input : compressed;
  }

  /* 1.7: "Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
  * write a method to rotate the image by 90 degrees. Can you do this in place?" */
  public static byte[][] rotateMatrix(byte[][] input) {
    return input;
  }

}
