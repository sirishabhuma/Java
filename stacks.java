import java.util.*;
public class stacks {
    public static class stack{
        static ArrayList <Integer> st=new ArrayList<>();
        public static boolean isEmpty(){
            if(st.size() == 0 ){
                return true;
            }else{
                return false;
            }
        }
        public static void push(int val){
            st.add(val);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int tos=st.get(st.size()-1);
            st.remove(st.size()-1);
            return tos;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int tos=st.get(st.size()-1);
            return tos;
        }
    }
    public static class StackL{
        public static class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                this.next=null;
            }
        }
        public static Node head=null;
        public static Node tail=null;
        public static boolean isEmpty(){
            if(head == null){
                return true;
            }else{
                return false;
            }
        }
        public static void push(int ele){
            Node n=new Node(ele);
            if(isEmpty()){
                head=n;
            }else{
                n.next=head;
                head=n;
            }
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }else{
                int temp=head.data;
                head=head.next;
                return temp;
            }
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        //stack s=new stack();
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // while(!stack.isEmpty()){
        //     System.out.println(stack.peek());
        //     stack.pop();
        // }
        StackL.push(1);
        StackL.push(2);
        StackL.push(3);
        System.out.println(StackL.pop());
        System.out.println(StackL.pop());
        System.out.println(StackL.pop());
    }
}
