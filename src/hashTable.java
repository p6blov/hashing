import java.util.Arrays;

class hashTable {
    private int size;
    private int[] table;

    public hashTable(int size) {
        this.size = size;
        table = new int[size];
        Arrays.fill(table, -1);
    }
    public hashTable() {
        table = new int[10];
        Arrays.fill(table, -1);
        this.size = table.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void empty() {
        Arrays.fill(table, -1);
    }

    private int hash1(int key) {
        return key % size;
    }

    private int hash2(int key) {
        return key % (size - 1);
    }

    private int getLinearProbIndex(int key, int i) {
        return (hash1(key) + i * i) % size;
    }

    private int getQuadraticProbIndex(int key, int i) {
        return (hash1(key) + i * i) % size;
    }

    private int getDoubleHash(int key, int i) {
        return (hash1(key) + i * hash2(key) % size);
    }

    private String method(String method) {
        return method.toLowerCase().substring(0, 1);
    }

    private int getIndex(int key, String m) {
        for (int i = 0; i < size; i++) {
            int index = switch (method(m)) {
                case "l" -> getLinearProbIndex(key, i);
                case "q" -> getQuadraticProbIndex(key, i);
                case "d" -> getDoubleHash(key, i);
                default -> throw new IllegalArgumentException("Invalid probing method. Please try again.");
            };
            if (table[index] == -1) {
                return index;
            }
        }
        return -1;
    }

    public boolean insert(int key, String method) {
        int index = getIndex(key, method);
        if (table[index] == -1) {
            table[index] = key;
            return true;
        }
        return false;
    }
    public boolean delete(int key, String method) {
        int index = getIndex(key, method);
        if(table[index] == key) {
            table[index] = -1;
            return true;
        }
        return false;
    }
    public boolean search(int key, String method) {
        int index = getIndex(key, method);
        return table[index] == key;
    }
    public void print() {print("");}
    public void print(String method) {
        String out = method.isEmpty() ? "Hash Table" : "Hash Table: " + method;
        for(int i = 0; i < size; i++) {
            out+= "\n" + i + ": ";
            if(table[i] != -1){
                out+= table[i];
            }
        }
        System.out.println(out + "\n\n---------------------\n");
    }
}