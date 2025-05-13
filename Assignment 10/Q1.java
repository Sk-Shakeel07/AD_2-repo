package assignment10;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total amount: ");
        int n = sc.nextInt();
        System.out.print("Enter number of coin denominations: ");
        int k = sc.nextInt();
        int[] d = new int[k];
        System.out.print("Enter coin denominations: ");
        for (int i = 0; i < k; i++) {
            d[i] = sc.nextInt();
        }
        int[] C = coinExchange(n, d, k);
        System.out.println("Minimum coins required: " + C[n]);
        System.out.print("Coins used: ");
        printCoins(n);
    }
    static int[] Deno;  
    public static int[] coinExchange(int n, int[] d, int k) {
        int[] C = new int[n + 1];
        Deno = new int[n + 1];
        Arrays.fill(C, Integer.MAX_VALUE);
        C[0] = 0;
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < k; i++) {
                if (j >= d[i] && C[j - d[i]] != Integer.MAX_VALUE && 1 + C[j - d[i]] < C[j]) {
                    C[j] = 1 + C[j - d[i]];
                    Deno[j] = d[i];
                }
            }
        }
        return C;
    }
    public static void printCoins(int j) {
        if (j > 0) {
            printCoins(j - Deno[j]);
            System.out.print(Deno[j] + " ");
        }
    }
}