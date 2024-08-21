import java.util.*;
public class Queues {
    static class queue{
        static int arr[];
        static int size;
        static int front;
        static int rear;
        queue(int n){
            arr=new int[n];
            size=n;
            rear=-1;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static boolean isFull(){
            //circular queue
            return (rear+1)%size == front;
        }
        public static void add(int val){
            if(rear < size-1){
                rear++;
                arr[rear]=val;
            }else{
                System.out.println("queue full");
            }
        }
        public static int remove(){
            if(isEmpty()){
                return -1;
            }else{
                front=arr[0];
                for(int i=0;i<arr.length-1;i++){
                    arr[i]=arr[i+1];
                }
                rear--;
                return front;
            }
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return arr[0];
        }
    }
    static class circularque{
        int front;
        int rear;
        int arr[];
        int size;
        circularque(int sz){
            arr=new int[sz];
            size=sz;
            rear=-1;
            front=-1;
        }
        public boolean isEmptyC(){
            if(rear == -1 && front == -1){
                return true;
            }
            return false;
        }
        public boolean isFullC(){
            if((rear+1)%size == front){
                return true;
            }
            return false;
        }
        public void enque(int val){
            if(isFullC()){
                return;
            }
            if(front == -1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=val;
            
        }
        public int deque(){
            if(isEmptyC()){
                return -1;
            }
            int res=arr[front];
            if(rear == front){
                rear=front=-1;
            }else{
                front=(front+1)%size;
            }
            return res;
        }
        public int peekC(){
            if(isEmptyC()){
                return -1;
            }
            return arr[front];

        }
    }
    public static String printFirstNonRepeatingChar(String str){
        int []freqChars=new int[26];
        Queue<Character> q=new LinkedList<>();
        String ans="";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            q.add(c);
            freqChars[c-'a']+=1;
            while(!q.isEmpty() && freqChars[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                ans+="-1";
            }else{
                ans+=""+q.peek();
            }
        }
        return ans;
    }
    public static void interleave(Queue<Integer> q){
        int size=q.size();
        Queue<Integer> q1=new LinkedList<>();
        for(int i=0;i<size/2;i++){
            q1.add(q.remove());
        }
        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
    public static void reverse(Queue<Integer> q){
        Stack<Integer> q1=new Stack<>();
        while(!q.isEmpty()){
            q1.push(q.remove());
        }
        while(!q1.isEmpty()){
            q.add(q1.pop());
        }
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
    public static void deque(){
        Deque<Integer> q=new LinkedList<>();
        q.addFirst(1);
        q.addLast(2);
        System.out.println(q.removeFirst());
        q.addFirst(3);
        System.out.println(q.removeLast());
    }
    public static void main(String[] args){
        // queue a=new queue(5);
        // a.add(1);
        // a.add(2);
        // a.add(4);
        // while(!a.isEmpty()){
        //     System.out.println(a.peek());
        //     a.remove();
        // }
        // circularque c=new circularque(5);
        // c.enque(1);
        // c.enque(2);
        // c.enque(3);
        // while(!c.isEmptyC()){
        //     System.out.println(c.deque());
        // }
        //System.out.println(printFirstNonRepeatingChar("aabccxb"));
        // Queue<Integer> q=new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        //interleave(q);
        // reverse(q);
        deque();
    }
}
