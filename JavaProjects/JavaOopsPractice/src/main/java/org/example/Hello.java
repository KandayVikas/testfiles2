package org.example;

interface Ae
{
    int x=10;
}
interface Be
{
    int x=100;
}
class Hello implements Ae,Be
{
    public static void Main(String args[])
    {
        /* reference to x is ambiguous both variables are x
         * so we are using interface name to resolve the
         * variable
         */
        //System.out.println(x);
        System.out.println(Ae.x);
        System.out.println(Be.x);
    }
}