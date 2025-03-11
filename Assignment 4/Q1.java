package assignment4;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        System.out.print("Enter the pattern to search: ");
        String pattern = sc.nextLine();
 
        int n = text.length(); 
        int m = pattern.length();
        boolean found = false;
      
        for (int i = 0; i <= n - m; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    flag = false; 
                    break;
                }
            }
            if (flag) { 
                System.out.println("Pattern found at index: " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Pattern not found!");
        }

    }
}
