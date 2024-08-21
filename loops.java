import java.util.*;

public class loops {
    public static Scanner s=new Scanner(System.in);
    public static void main(String[] args){
        int counter=0;
        while(counter<100){
            System.out.println("hello world"+counter);
            ++counter;
        }
        System.out.println(counter);
        int n=s.nextInt();
        int fact=factorial1(n);
        System.out.println("factorial :"+fact);
        fact();
        tables();
        sumofevenandodd();
        prime();
        sumofnaturals();
        forloop();
        reversenumber();
        dowhileloop();
        multipleof10();
        exceptmultiplesof10();
    }
    public static void prime(){
        int n=s.nextInt();
        int counter=0;
        if(n == 2){
            System.out.println("your number is prime");
        }else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i == 0){
                    counter++;
                }
            }
            if(counter < 1){
                System.out.println("prime number");
            }else{
                System.out.println("not a prime number");
            }
        }
        
    }
    public static void sumofnaturals(){
        System.out.println("sumofnaturals");
        int n=s.nextInt();
        int counter=1;
        int sum=0;
        while(counter <= n){
            sum+=counter;
            counter++;
        }
        System.out.println("sum of n natural nubers is "+sum);
    }
    public static void forloop(){
        System.out.println("for loop");
        int i=1;
        for(;i<10;){
            System.out.println("hello world");
            i++;
        }
    }
    public static void reversenumber(){
        System.out.println("reverse number");
        int number=s.nextInt();
        int sum=0;
        int reverse=0;
        while(number>0){
            reverse=number%10;
            sum=(sum*10)+reverse;
            number=number/10;
        }
        System.out.println(sum);
    }
    public static void dowhileloop(){
        int counter=1;
        do{
            System.out.println("do while");
            counter+=10;
        }while(counter < 10);
    }
    public static void multipleof10(){
        System.out.println("multiple of10");
        while(true){
            int number=s.nextInt();
            if(number%10 == 0){
                break;
            }
        }
    }
    public static void exceptmultiplesof10(){
        System.out.println("except multiples f 10");
        int number=0;
        while(true){
            number=s.nextInt();
            if(number % 10 == 0){
                continue;
            }
            System.out.println("number is "+number);
        }
    }
    public static void sumofevenandodd(){
        System.out.println("sum of even and odd");
        int n=s.nextInt();
        int i=0;
        int sumofeven=0;
        int sumofodd=0;
        while(i<n){
            int number=s.nextInt();
            if(number%2==0){
                sumofeven+=number;
            }else{
                sumofodd+=number;
            }
            i++;
        }
        System.out.println("sum of even number from set of integers is "+sumofeven);
        System.out.println("sum of odd number from set of integers is "+sumofodd);
    }
    public static int factorial1(int n){
        if(n>1){
            return n*factorial1(n-1);
        }
        return 1;
    }
    public static void fact(){
        System.out.println("fact");
        int value=1;
        System.out.println("enter factorial number");
        int n=s.nextInt();
        if(n==0 || n==1){
            System.out.println("the factorail of a given number is "+value);
        }else{
            for(int i=n;i>1;i-=2){
                value=i*(i-1)*value;
            }
        }
        System.out.println("factorial of the number is "+value);
    }
    public static void tables(){
        System.out.println("tables ");
        int n=s.nextInt();
        for(int i=1;i<=10;i++){
            int value=n*i;
            System.out.println(n+" * "+ i+" = "+value);
        }
    }
}
