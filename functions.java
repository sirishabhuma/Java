import java.util.*;

public class functions {
    public static Scanner s=new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter values");
        int a=s.nextInt();
        int b=s.nextInt();
        sum(a,b);
        swap(a,b);
        int product=productof(a,b);
        System.out.println("product of vlaues:"+product);
        System.out.println("the factorial of the given numbers is :"+factorial(b));
        System.out.println("the binomial coefficient of n and r is :"+binomialCoefficient(a,b));
        System.out.println("the overloading function sum is : "+sum(a,b,10));
        System.out.println("the overloading sum with different data types : "+sum(5,1.2));
        System.out.println("check if the given number is prime or not :"+prime(1));
        primeRange(a);
        System.out.println("conversion from binary to decimal");
        binarytodecimal();
        powerfun(2,5);
        dectobin();
        bintoany();
        dectoany();
        even();
        digitsum();
        System.out.println("palindrome value :"+pallindrome(131));
    }
    public static int sum(int a,int b){
        System.out.println("the sum of number is "+(a+b));
        return (a+b);
    }
    public static void swap(int a,int b){
        System.out.println(" a :"+a+" b :"+b+" swap function");
        int temp=0;
        temp=a;
        a=b;
        b=temp;
        System.out.println("a :"+a+" b :"+b);
    }
    public static int productof(int a,int b){
        return (a*b); 
    }
    public static int factorial(int b){
        if((b==0 || b==1) ){
            return 1;
        }
        else{
            int fact=1;
            for(int i=1;i<=b;i++){
                fact*=i;
            }
            return fact;
        }
    }
    public static int  binomialCoefficient(int n,int r){
        //ncr=n!/r!*(n-r)!
        int c=0;
        int n1=factorial(n);
        System.out.println("n! : "+n1);
        int r1=factorial(r);
        System.out.println("r! : "+r1);
        int n_r=factorial(n-r);
        System.out.println("(n-r)! : "+n_r);
        c=n1/(r1*(n_r));
        return c;
    }
    public static int sum(int a,int b,int c){
        //this is an function overloading function in which no of parameters
        // are different form the other function.
        return a+b+c;
    }
    public static double sum(int a,double b){
        //this is a overloading function in which different data types are used for
        //rather than different no of parameters
        double sum=(double)a+b;
        return sum;
    }
    public static boolean prime(int n){
        if(n == 1 || n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            //the code editor says dead code i.e code can't be reached with
            //incrementing so incriment is removed to avoid warning from editor.
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void primeRange(int n){
        for(int i=2;i<n;i++){
            if(prime(i)){
                System.out.println("prime : "+i);
            }
        }
    }
    public static void binarytodecimal(){
        System.out.println("enter a number in binary format :");
        int b=s.nextInt();
        int temp=b;
        int dec=0;
        int counter=0;
        while(temp > 0){
            //looping from the main variable and decrementing it and checking 
            //or terminating it if the value gets less than or equal to 0 
            b=temp%10;
            //extracting the last digit of the value 
            dec+=b*(int)powerfun(2,counter);
            //multiplying the last digit with 2 to the power of counter
            //adding the converted digit 
            counter++;
            //incrementing the counter 
            temp/=10;
            //decrementing the main value to avail for the condition of while loop
        }
        System.out.println(" "+dec);
    }
    public static void dectobin(){
        System.out.println("enter a decimal number to convert");
        int dec=s.nextInt();
        int lastdigit=0;
        int bin=0;
        int counter=0;
        while(dec >0 ){
            lastdigit=dec % 2;
            //get the last digit
            bin+=lastdigit*powerfun(10,counter);
            //we will multiply the last digit with the power of counter to base to 10
            // because the base number of decimal is 10

            dec/=2;
            counter++;
        }
        System.out.println("the binary value of given is "+bin);
    }
    public static int powerfun(int a,int b){
        int temp=1;
        while(b>0){
            temp*=a;
            b--;
        }
        return temp;
    }
    public static void bintoany(){
        System.out.println("enter number in bin format");
        int bin=s.nextInt();
        System.out.println("enter the base value of the number system to convert");
        int base=s.nextInt();
        int value=0;
        int counter=0;
        while(bin > 0){
            int rem=bin % 10;
            value=value+rem*powerfun(2,counter);
            counter++;
            bin/=base;
        }
        System.out.println("the value for the given number is "+value);
    }
    public static void dectoany(){
        System.out.println("enter a number in decimal format");
        int dec=s.nextInt();
        System.out.println("enter your base of the number system to convert");
        int base=s.nextInt();
        int counter=0;
        int value=0;
        while(dec > 0){
            int rem=dec % base;
            value=value+rem*powerfun(10,counter);
            counter++;
            dec/=base;
        }
        System.out.println("the value of the dec number in the given base number is "+value);
    }
    public static void practice1(){
        System.out.println("enter three numbers");
        int a=s.nextInt();
        int b=s.nextInt();
        int c=s.nextInt();
        int sum=a+b+c;
        System.out.println(" the avg value of the given is :"+sum/3);
        
    }
    public static boolean isEven(int n){
        boolean bool=true;
        if(n % 2 !=0){
            bool=false;
        }
        return bool;
    }
    public static void even(){
        System.out.println("enter a number");
        int n=s.nextInt();
        System.out.println("given values is even " +isEven(n));
    }
    public static boolean pallindrome(int n){
        int o=n;
        boolean bool=true;
        int value=0;
        while(n > 0 ){
            int rem=n%10;
            value=value*10+rem;
            
            n/=10;
        }
        if(value != o){
            bool=false;
        }
        return bool;
    }
    public static void digitsum(){
        System.out.println("enter a number to add the digits");
        int n=s.nextInt();
        int sum=0;
        while(n>0){
            int lastdigit=n%10;
            sum+=lastdigit;
            n/=10;
        }
        System.out.println("the sum of digits are "+sum);
    }
}
