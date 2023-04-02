package com.vikas;

public class PrimeNumber {
    //A prime number is a number that is divisible by only two numbers: 1 and itself.
//we are looping from 2 to num/2. It is because a number is not divisible by more than its half.

    public static void main(String[] args) {
        System.out.println(checkNumIsPrime(29));
        primeBtwGivenRange(3,23);
    }


    private static String checkNumIsPrime(int n) {

        int flag=0;
        for(int i=2;i<=n/2;i++){
            if(n % i==0){
//                System.out.println(n+""+i);
                flag=1;
                break;
            }
        }

        return  flag == 1 ? " not prime" : "prime";
    }

    private static void primeBtwGivenRange(int num1, int num2) {
        for (int i = num1; i <= num2; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }

        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for(int i=2;i<=n/2;i++){
            if(n % i==0){
               return false;
            }
        }
        return true;
    }
}
