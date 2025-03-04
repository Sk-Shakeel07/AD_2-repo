package assignment3;

public class Q5 { 
    public static void main(String[] args) {
        HashTableLP ht = new HashTableLP(1000);
        ht.add(1);
        ht.add(2);
        ht.add(3);
        ht.print();
        System.out.println(ht.remove(1)); 
        System.out.println(ht.remove(4));
        ht.print();
    }
}

class HashTableLP {
    private static final int EMPTY_VALUE = 0;
    private static final int DELETED_VALUE = 1;
    private static final int FILLED_VALUE = 2;

    private int tableSize;
    private int[] Arr;
    private int[] Flag;

    public HashTableLP(int tSize) {
        tableSize = tSize;
        Arr = new int[tSize];
        Flag = new int[tSize]; 
    }

    int computeHash(int key) {
        return key % tableSize;
    }

    int resolverFun(int index) {
        return 1; 
    }

    boolean add(int value) {
        int hashValue = computeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_VALUE || Flag[hashValue] == DELETED_VALUE) {
                Arr[hashValue] = value;
                Flag[hashValue] = FILLED_VALUE;
                return true;
            }
            hashValue = (hashValue + resolverFun(i)) % tableSize; 
        }
        return false; 
    }

    boolean find(int value) {
        int hashValue = computeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_VALUE) {
                return false;
            }
            if (Flag[hashValue] == FILLED_VALUE && Arr[hashValue] == value) {
                return true;
            }
            hashValue = (hashValue + resolverFun(i)) % tableSize;
        }
        return false;
    }

    boolean remove(int value) {
        int hashValue = computeHash(value);
        for (int i = 0; i < tableSize; i++) {
            if (Flag[hashValue] == EMPTY_VALUE) {
                return false;
            }
            if (Flag[hashValue] == FILLED_VALUE && Arr[hashValue] == value) {
                Flag[hashValue] = DELETED_VALUE;
                return true;
            }
            hashValue = (hashValue + resolverFun(i)) % tableSize;
        }
        return false;
    }

    void print() {
        for (int i = 0; i < tableSize; i++) {
            if (Flag[i] == FILLED_VALUE) {
                System.out.println("Node at index [" + i + "] :: " + Arr[i]);
            }
        }
    }
}
