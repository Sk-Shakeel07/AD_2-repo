package assignment6;
import java.util.*;
public class Q2 {
    static class Activity implements Comparable<Activity> {
        int start, stop;

        Activity(int s, int f) {
            start = s;
            stop = f;
        }
        public int compareTo(Activity s2) {
            return this.stop - s2.stop;
        }
    }
    public void maxActivities(int s[], int f[], int n) {
        Activity[] act = new Activity[n];
        for (int i = 0; i < n; i++)
            act[i] = new Activity(s[i], f[i]);
        Arrays.sort(act); 
        int i = 0; 
        System.out.print("Activities are: (" + act[i].start + "," + act[i].stop + ")");
        for (int j = 1; j < n; j++) {
            if (act[j].start >= act[i].stop) {
                System.out.print(", (" + act[j].start + "," + act[j].stop + ")");
                i = j;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.print("Enter the number of activities: ");
        int n = sc.nextInt();
        int[] s = new int[n]; 
        int[] f = new int[n];         
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time for activity " + (i + 1) + ": ");
            s[i] = sc.nextInt();
            System.out.print("Enter finish time for activity " + (i + 1) + ": ");
            f[i] = sc.nextInt();
        }      
        Q2 as = new Q2();
        as.maxActivities(s, f, n);
    }
}
 