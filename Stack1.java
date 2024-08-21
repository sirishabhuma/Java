import java.util.*;
public class Stack1 {
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }else{
            int tos=s.pop();
            pushAtBottom(s, data);
            s.push(tos);
        }
        return;
    }
    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        //push to the stack first
        int i=0;
        while(i<str.length()){
            s.push(str.charAt(i));
            i++;
        }
        //pop from the stack and append to the string
        StringBuilder res=new StringBuilder("");
        while(!s.isEmpty()){
            res=res.append(s.pop());
        }
        return res.toString();
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int tos=s.pop();
        reverseStack(s);
        pushAtBottom(s, tos);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static boolean isValid(String str){
        Stack<Character> s=new Stack<>();
        if(str.length()==0){
            return true;
        }
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch == '(' || ch=='[' || ch == '{'){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }else if((s.peek()=='(' && ch ==')') ||
                    (s.peek() == '{' && ch == '}')||
                    (s.peek() == '[' && ch==']')
                ){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        return (s.isEmpty());
    }
    public static boolean isDuplicate(String str){
        Stack <Character> s=new Stack<Character>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch == ')'){
                int count=0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count <1){
                    return true;
                }else{
                    
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void nextGreater(int []arr){
        Stack <Integer> s=new Stack<Integer>();
        int []ns=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ns[i]=-1;
            }else{
                ns[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<ns.length;i++){
            System.out.print(ns[i]+" ");
        }
    }
    public static void histogramArea(int []arr){
        int []nsl=new int[arr.length];
        int []nsr=new int[arr.length];
        Stack <Integer> s=new Stack<>();
        // next smaller left
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        //next smaller right
        s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        int maxarea=0;
        //area
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsl[i]+nsr[i];
            int curarea=height*width;
            maxarea=Math.max(curarea,maxarea);
        }
        System.out.println(maxarea);
    }
    public static void main(String[] args) {
        // Stack <Integer> s = new Stack<>();
        // s.push(());
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // reverseStack(s);
        // printStack(s);
        // pushAtBottom(s, 5);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        // String a="hello world";
        // System.out.println(reverseString(a));
        //System.out.println(Stack1.isValid("(({[]})){"));
        //int []a={5,6,7,4,9,3,1};
        //nextGreater(a);
        // System.out.println(isDuplicate("((a+b))"));
        int []a={2,1,5,6,2,3};
        histogramArea(a);
    }
}
