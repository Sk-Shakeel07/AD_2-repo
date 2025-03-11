package assignment4;
import java.util.*;

public class Q2 {
    public static int robinkarp(String textIn, String patternIn) {
        char[] text = textIn.toCharArray();
        char[] pattern = patternIn.toCharArray();
        int n = text.length;
        int m = pattern.length;
        int i, j;
        int prime = 101;
        int powm = 1;
        int TextHash = 0, PatternHash = 0;

        if (m == 0 || m > n) {
            return -1;
        }       
        for (i = 0; i < m - 1; i++) {
            powm = (powm * 2) % prime;
        }        
        for (i = 0; i < m; i++) {
            PatternHash = (PatternHash * 2 + pattern[i]) % prime;
            TextHash = (TextHash * 2 + text[i]) % prime;
        }        
        for (i = 0; i <= (n - m); i++) {
            if (TextHash == PatternHash) {
                for (j = 0; j < m; j++) {
                    if (text[i + j] != pattern[j]) {
                        break;
                    }
                }
                if (j == m)
                    return i; 
            }          
            if (i < n - m) {
                TextHash = ((TextHash - text[i] * powm) * 2 + text[i + m]) % prime;
                if (TextHash < 0) {
                    TextHash += prime;
                }
            }
        }

        return -1;
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        System.out.print("Enter the main text: ");
        String text = sc.nextLine();      
        System.out.print("Enter the pattern to search: ");
        String pattern = sc.nextLine();       
        int index = robinkarp(text, pattern);       
        if (index == -1) {
            System.out.println("Pattern not found in the text.");
        }
        else {
            System.out.println("Pattern found at index: " + index);
        }
    }
}
