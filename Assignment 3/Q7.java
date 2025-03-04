package assignment3;
import java.util.*;
public class Q7 {
	 private LinkedList<Integer>[] table;
	    private int capacity;
	    
		public Q7(int capacity) {
	        this.capacity = capacity;
	        table = new LinkedList[capacity];
	        for (int i = 0; i < capacity; i++) {
	            table[i] = new LinkedList<>();
	        }
	    } 
 
	    private int hash(int key) {
	        return key % capacity;
	    }

	    public void insert(int key) {
	        int index = hash(key);
	        table[index].add(key);
	    }

	    public boolean search(int key) {
	        int index = hash(key);
	        return table[index].contains(key);
	    }

	    public void display() {
	        for (int i = 0; i < capacity; i++) {
	            System.out.print("Bucket " + i + ": ");
	            for (int key : table[i]) {
	                System.out.print(key + " ");
	            }
	            System.out.println();
	        }
	    }


	public static void main(String[] args) {
		Q7 hashTable = new Q7(10);

        hashTable.insert(14);
        hashTable.insert(28);
        hashTable.insert(30);
        hashTable.insert(65);
        hashTable.insert(55);
        hashTable.insert(95);
        
        hashTable.display();

        System.out.println("Search 14: " + hashTable.search(14));
        System.out.println("Search 65: " + hashTable.search(65));

		

	}

}
