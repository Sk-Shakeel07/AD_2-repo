package assignment5;
import java.util.*;
public class Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        System.out.print("Enter first string (A): ");
        String A = scanner.nextLine(); 
        System.out.print("Enter second string (B): ");
        String B = scanner.nextLine();         
        char[] result = new char[A.length() + B.length()];        
        for (int i = 0; i < A.length(); i++) {
            result[i] = A.charAt(i);
        }        
        for (int i = 0; i < B.length(); i++) {
            result[i + A.length()] = B.charAt(i);
        }      
        System.out.println("Concatenated String: " + new String(result));
    }
}
