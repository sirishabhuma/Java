//import java.util.*;
public class LinkedList1{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
        
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node n1=new Node(data);
        size++;
        if(head == null){
            head=tail=n1;
            //System.out.println(n1.data);
            return;
        }
        n1.next=head;
        head=n1;
        //System.out.println(n1.data);
    }
    // public void sortedList(Node l1,Node l2){
    //     Node l3=null;
    //     Node temp;
    //     while(l1!=null && l2!=null){
    //         temp=(l1.data <= l2.data)?l1:l2;
    //         l3.data=-1;
    //         l3.next=temp;
    //         l1=l1.next;
    //         l2=l2.next;
    //     }
    // }
    public void addLast(int data){
        Node n1=new Node(data);
        size++;
        if(head == null){
            head=tail=n1;
            return;
        }
        tail.next=n1;
        tail=n1;
        //System.out.println(n1.data);
    }
    public void printList(){
        if(head == null){
            System.out.println("linked list is empty");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ->");
            temp=temp.next;
        }
        System.out.println();
    }
    public void addMiddle(int index,int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        
        Node temp=head;
        int counter=0;
        while( counter< index-1){
            temp=temp.next;
            counter++;
        }
        Node n1=new Node(data);
        n1.next=temp.next;
        temp.next=n1;
        size++;
    }
    public void removeFirst(){
        if(head == null){
            System.out.println("no elemensts ");
            return;
        }
        if(size ==1){
            head=tail=null;
            size--;
        }
        head=head.next;
        size--;
        
    }
    public void removeLast(){
        if(size == 0){
            System.out.println("no elements");
            return;
        }
        if(size == 1){
            head=tail=null;
            size--;
            return;
        }
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
    }
    public int search(int key){
        int position=0;
        Node temp=head;
        while(temp !=null){
            if(key == temp.data){
                return position;
            }
            temp=temp.next;
            position++;
        }
        return -1;
    }
    public int helper(Node head,int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int index=helper(head.next,key);
        if(index == -1){
            return -1;
        }
        return index+1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }
    public void reverseList(){
        Node p=null;
        Node c=tail=head;
        Node n;
        while(c!=null){
            n=c.next;
            c.next=p;
            p=c;
            c=n;
        }
        head=p;
    }
    public void remove(int n){
        int size=0;
        Node temp=head;
        while(temp !=null){
            temp=temp.next;
            size++;
        }
        if(size==n){
            head=head.next;
            return;
        }
        int i=0;
        int index=size-n-1;
        Node prev=head;
        while(i<index){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
    }
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast.next !=null && fast!=null){
            slow=slow.next; 
            fast=fast.next.next; 
        }
        return slow;
    }
    public boolean palindrome(Node mid){
        if(head==null || head.next==null){
            return false;
        }
        Node left=head;
        Node right=tail;
        Node prev=null;
        Node cur=tail=mid;
        Node next;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head=prev;
        mid.next=null;
        while(left!=null && right!=null){
            if(left.data == right.data){
                left=left.next;
                right=right.next;
            }else{
                return false;
            }
        }
        return true;
    }public boolean isCycle(){
        boolean res=false;
        Node slow=head;
        Node fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        } 
        return res;
    }
    public void removeCycle(){
        //detecting the cycle
        boolean loop=false; 
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                loop=true;
                break;
            }
        }
        if(loop == false){
            return;
        }
        //finding the meeting point
        Node prev=null;
        slow=head;
        while(slow !=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        //removing the cycle
        prev.next=null;
    }
    public Node mergeSort(Node head){
        //base case
        if(head == null || head.next == null){
            return head;
        }
        //finding mid
        Node mid=findmid(head);
        
        Node righthead=mid.next;
        mid.next=null;
        //recursions
        Node lefthalf=mergeSort(head);
        Node righthalf=mergeSort(righthead);
        return merge(lefthalf,righthalf);
    }
    public Node merge(Node lefthead,Node righthead){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(lefthead!=null && righthead!=null){
            if(lefthead.data<=righthead.data){
                temp.next=lefthead;
                lefthead=lefthead.next;
                temp=temp.next;
            }else{
                temp.next=righthead;
                righthead=righthead.next;
                temp=temp.next;
            }
        }
        while(lefthead!=null){
            temp.next=lefthead;
            lefthead=lefthead.next;
            temp=temp.next;
        }
        while(righthead!=null){
            temp.next=righthead;
            righthead=righthead.next;
            temp=temp.next;
        }
        return dummy.next;
    }

    public Node findmid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void zigZag(){
        // find the mid node
        //slow fast approach
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        //reversing the second half
        Node prev=null;
        Node cur=mid.next;
        Node Next;
        while(cur!=null ){
            Next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=Next;
        }
        mid.next=null;
        //attaching the left head and right heads of the list
        Node lefthead=head;
        Node righthead=tail;
        Node leftnext;
        Node rightnext;
        while(lefthead !=null && righthead!=null){
            leftnext=lefthead.next;
            lefthead.next=righthead;
            rightnext=righthead.next;
            righthead.next=leftnext;
            lefthead=leftnext;
            righthead=rightnext;
        }
    }
    
    public static void main(String[] args) {
        LinkedList1 l1=new LinkedList1();
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.addLast(6);
        // l1.printList();
        // System.out.println("size :"+size);
        //l1.removeFirst();
        // l1.printList();
        // l1.removeLast();
        // System.out.println("remove last");
        // l1.printList();
        //System.out.println(tail.data);
        //l1.printList();
        //System.out.println(l1.search(1));
        //System.out.println(l1.recSearch(11));
        //l1.reverseList();
        //l1.remove(3);
        // System.out.println(l1.findMid(head).data);
        // l1.printList();
        // System.out.println(l1.palindrome(l1.findMid(head)));
        // head=new Node(1);
        // head.next=new Node(2);
        // head.next.next=new Node(3);
        // head.next.next.next=head.next;
        // System.out.println(l1.isCycle());
        // l1.removeCycle();
        //System.out.println(l1.isCycle());
        // l1.printList();
        // head=l1.mergeSort(head);
        // l1.printList();
        l1.printList();
        l1.zigZag();
        l1.printList();
    }

}