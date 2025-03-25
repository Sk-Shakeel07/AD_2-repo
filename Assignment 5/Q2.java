package assignment5;
import java.util.*;
public class Q2 {

    public static boolean isUniqueChar(String str) {
        int[] bitarr = new int[26]; 
        int index;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);            
            if (c >= 'A' && c <= 'Z') {
                index = c - 'A';
            } 
            else if (c >= 'a' && c <= 'z') {
                index = c - 'a';
            } 
            else {
                System.out.println("Unknown Char!\n");
                return false;
            }           
            if (bitarr[index] != 0) {
                System.out.println("Duplicate detected!");
                return false;
            }
            bitarr[index] = 1;
        }
        System.out.println("No duplicate detected!");
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        isUniqueChar(input); 
    }
}
