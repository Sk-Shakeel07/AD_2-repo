package assignment3;

public class Q6 {
	 private int[] table;
	    private int capacity;

	    public Q6(int capacity) {
	        this.capacity = capacity;
	        table = new int[capacity];
	        for (int i = 0; i < capacity; i++) {
	            table[i] = -1; 
	        }
	    }

	    private int hash(int key) {
	        return key % capacity;
	    }

	    public void insert(int key) {
	        int index = hash(key);
	        int i = 1;
	        while (table[index] != -1) {
	            index = (hash(key) + i * i) % capacity;
	            i++;
	        }
	        table[index] = key;
	    }

	    public boolean search(int key) {
	        int index = hash(key);
	        int i = 1;
	        while (table[index] != -1) {
	            if (table[index] == key) {
	                return true;
	            }
	            index = (hash(key) + i * i) % capacity;
	            i++;
	        }
	        return false;
	    }

	    public void display() {
	        for (int i = 0; i < capacity; i++) {
	            if (table[i] != -1) {
	                System.out.print(table[i] + " ");
	            } else {
	                System.out.print("-1 "); 
	            }
	        }
	        System.out.println();
	    }


	public static void main(String[] args) {
		 Q6 hashTable = new Q6(10);

	        hashTable.insert(10);
	        hashTable.insert(20);
	        hashTable.insert(30);
	        hashTable.insert(40);
         hashTable.insert(35);
         
	        hashTable.display();

	        System.out.println("Search 20: " + hashTable.search(20));
	        System.out.println("Search 50: " + hashTable.search(50));


	}

}
