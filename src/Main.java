public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
class hashTable {
    private int size;
    private int[] table;

    public hashTable() {
        table = new int[10];
        size = 0;
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    private int hash1(int key) {return key % size;}

    private int hash2(int key) {return key % (size - 1);}
}