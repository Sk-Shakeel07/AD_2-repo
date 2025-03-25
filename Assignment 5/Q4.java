package assignment5;
import java.util.*;
public class Q4 {

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        }
        if (i < j) {
            System.out.println("String is not a Palindrome");
            return false;
        } else {
            System.out.println("String is a Palindrome");
            return true;
        } 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        isPalindrome(input);
    } 
}
