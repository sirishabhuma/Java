import java.util.Scanner;

public class conditionalst {
    public static Scanner s=new Scanner(System.in);
    public static void main(String[] args){
        int income=100000;
        double tax;
        if(income <5000 ){
            tax=(income*0.0);
        }else if(income >= 50000 && income < 10000){
            tax=(income*0.2);
        }else{
            tax=(income*0.3);
        }
        System.out.println("tax ="+ tax);
        float a=(float)20/100;
        System.out.println(a);
        largest(23,22,20);
        ternary(10,6);
        passorfail();
        calculator();
        norp();
        fever();
        weekday();
        leapyear();
    }
    public static void largest(int a,int b,int c){
        if(a > b && a > c ){
            System.out.println("a is largest");
        }else if(b > c){
            System.out.println("b is largest");
        }else{
            System.out.println("c is largest");
        }
    }
    public static void ternary(int a,int b){
        
        String value=(a%2 == 0)?"even":"odd";
        System.out.println(value);
    }
    public static void passorfail(){
        System.out.println("sfhahsfka");
        float marks=s.nextFloat();
        boolean val=(marks >= 33)?true:false;
        System.out.println("student passed the exam "+val);
    }
    public static void calculator(){
        int b=s.nextInt();
        int a=s.nextInt();
        System.out.println("enter operator");
        char c=s.next().charAt(0);
        switch(c){
            case '+': 
                System.out.println(b+a);
                break;
            case '-' : 
                System.out.println(a-b);
                break;
            case '*' : 
                System.out.println(a*b);
                break;
            case '/' : 
                System.out.println(a/b);    
                break;
            case '%': 
                System.out.println(a%b);
                break;
            default:
                System.out.println("enter proper character");
        }
    }
    public static void norp(){
        System.out.println("enter 2 number :");
        int a=s.nextInt();
        String val=(a>=0)?"postive":"negative";
        System.out.println("the value is "+val);
    }
    public static void fever(){
        double f=s.nextDouble();
        System.out.println((f >= 100.0)?"you have a fever":"you do not have a fever");
    }
    public static void weekday(){
        System.out.println("enter weekday");
        int a=s.nextInt();
        switch (a){
            case 1:
                System.out.println("monday");
                break;
            case 2:
                System.out.println("tuesday");
                break;
            case 3:
                System.out.println("wednesday");
                break;
            case 4:
                System.out.println("thursday");
                break;
            case 5:
                System.out.println("friday");
                break;
            case 6:
                System.out.println("saturday");
                break;
            case 7:
                System.out.println("sunday");
                break;
            default :
                System.out.println("please enter number among 1 and 7");
        }
    }
    public static void leapyear(){
        System.out.println("enter year");
        int year=s.nextInt();
        if(year%4 ==0 ){
            if(year%100==0){
                if(year%400 != 0){
                    System.out.println("leapyear");
                }else{
                    System.out.println("not a leap year");
                }
            }else{
                System.out.println("leapyear");
            }
        }else{
            System.out.println("not a leap year");
        }
    }
}
