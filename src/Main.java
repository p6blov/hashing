public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
class hashNode<x, y> {
    x key;
    y value;
    final int hashCode;

    //reference to next node
    hashNode<x, y> next;

    //constructor
    public hashNode(x key, y value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

class Table<x, y> {
    private int numBuckets;
    private int size;
    private hashNode<x, y>[] buckets;

    public Table() {
        buckets = new hashNode[10];
        numBuckets = buckets.length;
        size = 0;
    }

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    private final int hashCode(x key) {return key.hashCode();}

    private int getBucketIndex(x key) {
        int hash = hashCode(key);
        int i = hash % numBuckets;
        i = i < 0 ? i * -1 : i;
        return i;
    }
}