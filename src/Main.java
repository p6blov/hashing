public class Main {
    public static void main(String[] args) {
        hashTable table = new hashTable();

        int[] nums = {10, 20, 15, 5, 25, 30};
        fillLinear(table, nums);
        table.print("Linear");

        hashTable table1 = new hashTable();
        int[] num1 = {99, 77, 55, 66, 88, 44, 22};
        fillQuadratic(table1, num1);
        table.print("Quadratic");

        hashTable table2 = new hashTable();
        int[] num2 = {1, 2, 3, 4, 5, 6, 7};
        fillDouble(table2, num2);
        table.print("Double Hash");
    }
    public static void fill(hashTable table, int[] nums, String method) {
        for(int n : nums)
            System.out.println("Able to add: " + table.insert(n, method));
    }
    public static void fillLinear(hashTable table, int[] nums) {
        for(int n : nums)
            table.insert(n, "Linear");
    }
    public static void fillQuadratic(hashTable table, int[] nums) {
        for(int n : nums)
            table.insert(n, "Quadratic");
    }
    public static void fillDouble(hashTable table, int[] nums) {
        for(int n : nums)
            table.insert(n, "Double Hash");
    }
    public static void fillAll(hashTable table, int[] nums) {
        fillLinear(table, nums);
        table.print("Linear");
        table.empty();

        fillQuadratic(table, nums);
        table.print("Quadratic");
        table.empty();

        fillDouble(table, nums);
        table.print("Double Hash");
        table.empty();
    }
}