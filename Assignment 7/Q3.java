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
        this.character = '\0'; // internal node
        this.weight = left.weight + right.weight;
        this.left = left;
        this.right = right;
    }
}

public class Q3 {
    public static Node buildHuffmanTree(char[] characters, int[] weights) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (int i = 0; i < characters.length; i++) {
            pq.offer(new Node(characters[i], weights[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left, right);
            pq.offer(parent);
        }

        return pq.poll(); // root of the tree
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

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Count character frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Convert map to arrays
        int n = freqMap.size();
        char[] characters = new char[n];
        int[] weights = new int[n];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            characters[index] = entry.getKey();
            weights[index] = entry.getValue();
            index++;
        }

        // Build Huffman tree and generate codes
        Node root = buildHuffmanTree(characters, weights);
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);

        // Display Huffman Codes
        System.out.println("\nHuffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }

        // Calculate total bits used in Huffman encoding
        int totalHuffmanBits = 0;
        for (char ch : input.toCharArray()) {
            totalHuffmanBits += huffmanCodes.get(ch).length();
        }

        // Fixed length: ceil(log2 of unique characters) × total characters
        int fixedBitsPerChar = (int) Math.ceil(Math.log(n) / Math.log(2));
        int totalFixedBits = input.length() * fixedBitsPerChar;

        System.out.println("\nTotal bits required:");
        System.out.println("Fixed-length encoding: " + totalFixedBits);
        System.out.println("Huffman encoding: " + totalHuffmanBits + " bits");

        sc.close();
    }
}
