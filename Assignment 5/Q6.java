package assignment5;
import java.util.*;
public class Q6 {
	public static String reverseString(String str) {
        char[] a = str.toCharArray();
        reverseStringUtil(a);
        return new String(a);
    }
    public static void reverseStringUtil(char[] a) {
        int lower = 0;
        int upper = a.length - 1;
        char tempChar;
        while (lower < upper) {
            tempChar = a[lower];
            a[lower] = a[upper];
            a[upper] = tempChar;
            lower++;
            upper--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = sc.nextLine();
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }  
}
