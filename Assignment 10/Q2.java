package assignment10;
import java.util.*;
public class Q2 {
    static class Job {
        int start, finish, weight;
        Job(int start, int finish, int weight) {
            this.start = start;
            this.finish = finish;
            this.weight = weight;
        }
    }
    static int latestNonConflict(Job[] jobs, int index) { 
        for (int j = index - 1; j >= 0; j--) {
            if (jobs[j].finish <= jobs[index].start) {
                return j;
            }
        }
        return -1;
    }
    static int[] findMaxWeight(Job[] jobs) {
        int n = jobs.length;
        int[] dp = new int[n];
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.finish));
        dp[0] = jobs[0].weight;
        for (int i = 1; i < n; i++) {
            int includeWeight = jobs[i].weight;
            int l = latestNonConflict(jobs, i);
            if (l != -1) {
                includeWeight += dp[l];
            }
            dp[i] = Math.max(includeWeight, dp[i - 1]);
        }

        return dp;
    }
    static void printSelectedJobs(Job[] jobs, int[] dp) {
        int i = jobs.length - 1;
        System.out.println("\nSelected jobs in optimal schedule:");
        while (i >= 0) {
            int includeWeight = jobs[i].weight;
            int l = latestNonConflict(jobs, i);
            if (l != -1) {
                includeWeight += dp[l];
            }
            if (includeWeight > (i > 0 ? dp[i - 1] : 0)) {
                System.out.println("Start: " + jobs[i].start + ", Finish: " + jobs[i].finish + ", Weight: " + jobs[i].weight);
                i = l;
            }
            else {
                i--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Job " + (i + 1) + ":");
            System.out.print("  Start time: ");
            int start = sc.nextInt();
            System.out.print("  Finish time: ");
            int finish = sc.nextInt();
            System.out.print("  Weight: ");
            int weight = sc.nextInt();
            jobs[i] = new Job(start, finish, weight);
        }
        int[] dp = findMaxWeight(jobs);
        System.out.println("\nMaximum total weight of non-overlapping jobs: " + dp[dp.length - 1]);
        printSelectedJobs(jobs, dp);
    }
}