import java.util.*;
public class bitwise {
    public static Scanner s=new Scanner(System.in);
    public static void main(String[] args){
        // System.out.println(5 & 6);
        // System.out.println(5 | 6);
        // System.out.println(5 ^ 6);
        // System.out.println(~6);
        // System.out.println(5 >> 2);
        // evenorodd();
        // System.out.println(getIth());
        // System.out.println(setIth());
        // System.out.println(getIth());
        //System.out.println(clearIth()); 
        // System.out.println(getIth());
        // updateIthbit();
        //System.out.println(clearAllIbits());
        //System.out.println(clearBitsInRange());
        //countBits();
        //powerOf2();
        //powerOfAnyNumber();
        System.out.println(5 ^ 5);
        System.out.println((5&1) + (5|1));
        swap();
    }
    public static void evenorodd(){
        System.out.println("enter a value");
        int a=s.nextInt();

        if( (a&1) == 1){
            System.out.println("odd");
        }else{
            System.out.println("even");
        }
    }
    public static int getIth(){
        System.out.println("get ith");
        System.out.println("enter a number ");
        int n=s.nextInt();
        System.out.println("enter ith value");
        int i=s.nextInt();
        int bitmask=1 << i;
        return n= n&bitmask;
    }
    public static int setIth(){
        System.out.println("set ith");
        System.out.println("enter a value");
        int n=s.nextInt();
        System.out.println("enter ith value ");
        int i=s.nextInt();
        int bitmask=1 << i;
        n= n | bitmask;
        return n;
    }
    public static int clearIth(){
        System.out.println("enter n value");
        int n=s.nextInt();
        System.out.println("enter i th value");
        int i=s.nextInt();
        int bitmask=~(1 << i);
        return n & bitmask;
    }
    public static void updateIthbit(){
        System.out.println("update ith bitmask");
        System.out.println("enter n value");
        int n=s.nextInt();
        System.out.println("enter i th term");
        int i=s.nextInt();
        System.out.println("enter updating value");
        int j=s.nextInt();
        if(j == 0){
            int bitmask=~(1<<i);
            System.out.println( n&bitmask );
        }else{
            int bitmask=1 << i;
            System.out.println( n | bitmask);
        }
    }
    public static int clearAllIbits(){
        System.out.println("clear all i bits");
        System.out.println("enter n value");
        int n=s.nextInt();
        System.out.println("enter ith value");
        int i=s.nextInt();
        int bitmask=(~0 << i);
        return n&bitmask;
    }
    public static int clearBitsInRange(){
        System.out.println("clear range ");
        System.out.println("enter n value");
        int n=s.nextInt();
        System.out.println("enter i th vlaue");
        int i=s.nextInt();
        System.out.println("enter j value");
        int j=s.nextInt();
        int a=((~0)<< j+1);
        int b=(1<<i)-1;
        int bitmask=a | b;
        return n&bitmask; 
    }
    public static void countBits(){
        System.out.println("the value of n is :");
        int n=s.nextInt();
        int count=0;
        while(n > 0){
            if( (n & 1) !=0){
                count++;
            }
            n=n>>1;
        }
        System.out.println(count);
    }
    public static void powerOf2(){
        System.out.println("enter a value");
        int n=s.nextInt();
        boolean b=true;
        if( (n & n-1)==0 ){
            b=true;
        }else{
            b=false;
        }
        System.out.println("the given value is power of 2 : " +b);
    }
    public static void powerOfAnyNumber(){
        System.out.println("enter a value : ");
        int n=s.nextInt();
        System.out.println("enter a power value : ");
        int m=s.nextInt();
        int ans=1;
        while(m > 0){
            if((m&1)!=0){
                ans=ans*n;
            }
            n=n*n;
            m=m>>1;
        }
        System.out.println(ans);
    }
    public static void swap(){
        int a=s.nextInt();
        int b=s.nextInt();
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("a : "+a+"b : "+b);
    }
}