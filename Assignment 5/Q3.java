package assignment5;
import java.util.*;
public class Q3 {

    public static char toUpper(char s) {
        if (s >= 'a' && s <= 'z') {
            return (char) (s - 32);
        }
        return s;
    }
    public static char toLower(char s) {
        if (s >= 'A' && s <= 'Z') {
            return (char) (s + 32);
        }
        return s;
    }
    public static String convertCase(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                result.append(toUpper(c));
            } 
            else if (Character.isUpperCase(c)) {
                result.append(toLower(c));
            } 
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();      
        String output = convertCase(input);
        System.out.println("Converted String: " + output);
    }
}
