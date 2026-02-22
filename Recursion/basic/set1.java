package basic;

public class set1 {
    public static void main(String[] args) {
//        NToOne(5);
//        System.out.println();
//        System.out.println(prod_nto1(5));
        System.out.println(prod_digits(1348));
    }

    public static void NToOne(int n){
        //base case
        if(n == 0)
            return;
        System.out.print(n+" ");
        NToOne(n-1);
    }

    public static int prod_nto1(int n){
        if(n==1) return n;

        return n * prod_nto1(n-1);
    }

    public static int sum_n(int n){
        if (n==0) return n;

        return n + sum_n(n-1);
    }

//    public static int fibo(int n){
//        if (n==0) return n;
//
//        return n;
//    }

    public static int sum_digits(int n){
        if (n==0) return 0;

        return (n%10) + sum_digits(n/10);
    }

    public static int prod_digits(int n){
        if (n==0) return 1;

        return (n%10) * prod_digits(n/10);
    }


}
