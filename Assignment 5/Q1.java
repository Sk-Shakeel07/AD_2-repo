package assignment5;
import java.util.*;
public class Q1 {
    
    public static boolean match(String src, String ptn) {
        char[] source = src.toCharArray();
        char[] pattern = ptn.toCharArray();
        int iPattern = 0;
        int patternLen = pattern.length;

        for (int iSource = 0; iSource < source.length; iSource++) {
            if (source[iSource] == pattern[iPattern]) {
                iPattern++;
            }
            if (iPattern == patternLen) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        System.out.print("Enter the source string: ");
        String source = sc.nextLine();        
        System.out.print("Enter the pattern string: ");
        String pattern = sc.nextLine();        
        if (match(source, pattern)) {
            System.out.println("Matching order: Yes");
        } else {
            System.out.println("Matching order: No");
        }       
    }
}