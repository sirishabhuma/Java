import java.util.Stack;

public class Que {
    static class Ques{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int remove(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        //Ques q=new Ques();
        Ques.add(1);
        Ques.add(2);
        Ques.add(3);
    }
}
