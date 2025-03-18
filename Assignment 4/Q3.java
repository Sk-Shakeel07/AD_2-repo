package assignment4;
import java.util.*;
class Algo {
    void KMPPreprocess(char[] pattern, int[] ShiftArr) {
        final int m = pattern.length;
        int i = 0, j = -1;
        ShiftArr[i] = -1;

        while (i < m) {
            while (j >= 0 && pattern[i] != pattern[j]) {
                j = ShiftArr[j];
            }
            i++;
            j++;
            ShiftArr[i] = j;
        }
    }
    int KMP(String text, String pattern) {
        return KMP(text.toCharArray(), pattern.toCharArray());
    }
    int KMP(char[] text, char[] pattern) {
        int i = 0, j = 0;
        final int n = text.length;
        final int m = pattern.length;
        int[] ShiftArr = new int[m + 1]; 
        KMPPreprocess(pattern, ShiftArr);

        while (i < n) {
            while (j >= 0 && text[i] != pattern[j]) {
                j = ShiftArr[j];
            }
            i++;
            j++;
            if (j == m) {
                return (i - m); 
            }
        }
        return -1; 
    }
    int KMPFindCount(char[] text, char[] pattern) {
        int i = 0, j = 0, count = 0;
        final int n = text.length;
        final int m = pattern.length;
        int[] ShiftArr = new int[m + 1];
        KMPPreprocess(pattern, ShiftArr);
        while (i < n) {
            while (j >= 0 && text[i] != pattern[j]) {
                j = ShiftArr[j];
            }
            i++;
            j++;
            if (j == m) {
                count++;
                j = ShiftArr[j]; 
            }
        }
        return count;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        System.out.print("Enter the pattern to search: ");
        String pattern = sc.nextLine();
        Algo algo = new Algo();
        int firstOccurrence = algo.KMP(text, pattern);
        int countOccurrences = algo.KMPFindCount(text.toCharArray(), pattern.toCharArray());        
        if (firstOccurrence != -1) {
            System.out.println("Pattern found at index: " + firstOccurrence);
        } 
        else {
            System.out.println("Pattern not found.");
        }
        System.out.println("Total occurrences: " + countOccurrences);       
    }
}
