package basic;

public class reverse {
    public static int rev(int n){
        int digits = (int) (Math.log10(n))+1;
        return helper(n, digits);
    }

    public static int helper(int n, int digits) {
        if (n%10 == n) return n;

        return (int) ((n%10) * Math.pow(10, digits-1) + helper(n/10, digits-1));
    }

    public static void main(String[] args) {
        System.out.println(rev(4796));
    }
}
