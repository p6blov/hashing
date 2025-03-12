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

    public boolean insert(int key, String method) {
        for(int i = 0; i < size; i++) {
            int index;

            switch (method(method)) {
                case "l":
                    index = getLinearProbIndex(key, i);
                    break;
                case "q":
                    index = getQuadraticProbIndex(key, i);
                    break;
                case "d":
                    index = getDoubleHash(key, i);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid probing method. Please try again.");
            }
            if (table[index] == -1) {
                table[index] = key;
                return true;
            }
        }
        return false;
    }
}