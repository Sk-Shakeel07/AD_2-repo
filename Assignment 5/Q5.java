package assignment5;
import java.util.*;
public class Q5 {

    public static int myStrcmp(String a, String b) {
        int index = 0;
        int len1 = a.length();
        int len2 = b.length();
        int minlen = Math.min(len1, len2);
        while (index < minlen && a.charAt(index) == b.charAt(index)) {
            index++;
        }
        if (index == len1 && index == len2) {
            return 0; 
        } 
        else if (len1 == index) {
            return -1;
        } 
        else if (len2 == index) {
            return 1; 
        } 
        else {
            return a.charAt(index) - b.charAt(index);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();       
        int result = myStrcmp(str1, str2);
        if (result == 0) {
            System.out.println("The strings are equal.");
        } 
        else if (result < 0) {
            System.out.println("The first string is smaller than the second string.");
        } 
        else {
            System.out.println("The first string is greater than the second string.");
        }
    }
}
