package assignment7;
import java.util.*;
class Node {
    char character;  
    int weight;      
    Node left, right; 

    Node(char character, int weight) {
        this.character = character;
        this.weight = weight;
        this.left = this.right = null;
    }

    Node(Node left, Node right) {
        this.character = '\0'; 
        this.weight = left.weight + right.weight;
        this.left = left;
        this.right = right;
    }
}
public class Q2 {
	public static Node buildHuffmanTree(char[] characters, int[] weights) {
        int n = characters.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (int i = 0; i < n; i++) {
            pq.offer(new Node(characters[i], weights[i]));
        }
        while (pq.size() > 1) {
            Node left = pq.poll();  
            Node right = pq.poll();
            Node parent = new Node(left, right);
            pq.offer(parent);
        }
        return pq.poll();
    }
    public static void generateHuffmanCodes(Node root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.character, code);
        }
        generateHuffmanCodes(root.left, code + "0", huffmanCodes);
        generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of characters: ");
        int n = sc.nextInt();
        char[] characters = new char[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            characters[i] = sc.next().charAt(0);
            System.out.print("Enter weight for " + characters[i] + ": ");
            weights[i] = sc.nextInt();
        }
        Node root = buildHuffmanTree(characters, weights);
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);
        System.out.println("\nHuffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
