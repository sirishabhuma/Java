public class Linkedlist {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head=null;
    public static Node tail=null;
    public void addFirst(int data){
        Node n1=new Node(data);
        System.out.println(n1.data);
        if(head == null){
            head=tail=n1;
            return;
        }
        n1.next=head;
        head=n1;
    }
    public int tail1(Node n1){
        //Node head=n1;
        while(n1!=null && n1.next!=null ){
            tail=n1.next;
        }
        return tail.data;
    }
    public static void main(String[] args){
        Linkedlist l1=new Linkedlist();
        l1.addFirst(1);
        l1.addFirst(2);
        System.out.println(l1.tail1(head));
    }
}
