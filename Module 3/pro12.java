    public class pro12 {
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("Sum of two ints: " + add(5, 10));
        System.out.println("Sum of two doubles: " + add(3.5, 2.5));
        System.out.println("Sum of three ints: " + add(1, 2, 3));
    }
}
