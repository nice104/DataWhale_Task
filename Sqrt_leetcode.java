package leetCode;

public class Sqrt_leetcode {
    public static void main(String[] args) {

        int num = 37;
        System.out.println(sqrtL(num));
        System.out.println(Math.sqrt(num));
    }

    static int sqrtL(int x) {

        int i;
        for ( i = 0; i < x / 2; i++) {
            if (i*i > x) break;
        }

        return i-1;
    }
}
