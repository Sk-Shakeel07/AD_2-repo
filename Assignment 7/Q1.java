package assignment7;
import java.util.*;
public class Q1 {
    static class HuffmanTree {
        Node root = null;
        class Node implements Comparable<Node> {
            char c;
            int freq;
            Node left, right;
            Node(char ch, int fr, Node l, Node r) {
                c = ch;
                freq = fr;
                left = l;
                right = r;
            }
            public int compareTo(Node n2) {
                return this.freq - n2.freq;
            }
        }
        HuffmanTree(char[] arr, int[] freq) {
            int n = arr.length;
            if (n == 0) {
                throw new IllegalArgumentException("Input arrays cannot be empty");
            }
            PriorityQueue<Node> que = new PriorityQueue<>(n);
            for (int i = 0; i < n; i++) {
                Node node = new Node(arr[i], freq[i], null, null);
                que.add(node);
            }
            while (que.size() > 1) {
                Node lt = que.poll();
                Node rt = que.poll();
                Node nd = new Node('\0', lt.freq + rt.freq, lt, rt); 
                que.add(nd);
            }
            root = que.peek();
        }
        private void print(Node root, String s) {
            if (root.left == null && root.right == null) {
                System.out.println(root.c + " = " + s);
                return;
            }
            print(root.left, s + "0");
            print(root.right, s + "1");
        }
        public void print() {
            if (root == null) {
                System.out.println("Huffman Tree is empty.");
                return;
            }
            System.out.println("Char = Huffman Code");
            print(root, "");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of characters: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        char[] ar = new char[n];
        int[] fr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            ar[i] = sc.next().charAt(0);
            System.out.print("Enter frequency of " + ar[i] + ": ");
            fr[i] = sc.nextInt();
        }
        HuffmanTree hf = new HuffmanTree(ar, fr);
        hf.print();
    }
}