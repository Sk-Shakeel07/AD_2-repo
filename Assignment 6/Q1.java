package assignment6;
import java.util.*;
public class Q1 {
	 private static class Items implements Comparable<Items> {
	        int wt, cost;
	        double density;
	        Items(int w, int c) {
	            wt = w;
	            cost = c;
	            density = (double) cost / wt;
	        }
	        public int compareTo(Items s2) {
	            return Double.compare(s2.density, this.density); 
	        }
	    }
	    public double getMaxCostFractional(int[] W, int[] C, int Wk) {
	        int n = W.length;
	        double totalCost = 0;
	        int Weight = 0;
	        Items[] itemList = new Items[n];
	        for (int i = 0; i < n; i++) {
	            itemList[i] = new Items(W[i], C[i]);
	        }
	        Arrays.sort(itemList); 
	        for (int i = 0; i < n; i++) {
	            if (Weight + itemList[i].wt <= Wk) {
	                Weight += itemList[i].wt;
	                totalCost += itemList[i].cost;
	            } 
	            else {
	                totalCost += itemList[i].density * (Wk - Weight);
	                break;
	            }
	        }
	        return totalCost;
	    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[] W = new int[n];
        int[] C = new int[n];
        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            W[i] = sc.nextInt();
        }
        System.out.println("Enter costs of items:");
        for (int i = 0; i < n; i++) {
            C[i] = sc.nextInt();
        }
        System.out.print("Enter knapsack capacity: ");
        int Wk = sc.nextInt();
        Q1 kp = new Q1(); 
        double maxCost = kp.getMaxCostFractional(W, C, Wk);
        System.out.println("Maximum cost obtained (Sorting) = " + maxCost);      
    } 
}