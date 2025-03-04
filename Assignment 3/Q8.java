package assignment3;
import java.util.*;
public class Q8 {
    public static boolean isAnagram(char[] str1, char[] str2) {
        if (str1.length != str2.length) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char ch : str1) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2) {
            if (!hm.containsKey(ch) || hm.get(ch) == 0)
                return false;
            hm.put(ch, hm.get(ch) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String input1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String input2 = sc.nextLine();

        boolean result = isAnagram(input1.toCharArray(), input2.toCharArray());
        System.out.println();

        if (result) {
            System.out.println("The strings are anagrams.");
        }
        else {
            System.out.println("The strings are NOT anagrams.");
        }
    }
}
