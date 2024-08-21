import java.util.ArrayList;
import java.util.List;

public class BinarySearchTrees {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static Node insert(Node root,int val){
        if(root == null){
            return new Node(val,null,null);
        }
        if(val < root.val){
            root.left=insert(root.left,val);
        }else if(val > root.val){
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.val == key){
            return true;
        }
        
        if(root.val > key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }
    public static Node delete(Node root,int key){
        if(key < root.val){
            return delete(root.left,key);
        }else if(key > root.val){
            return delete(root.right,key);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            else{
                Node is=inorderSucessor(root.right);
                root.val=is.val;
                root.right=delete(root.right,is.val);
            }
        }
        return root;
    }
    public static Node inorderSucessor(Node root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void print(Node root,int k1,int k2){
        if(root == null){
            return ;
        }
        if(root.val >= k1 && root.val <= k2){
            print(root.left,k1,k2);
            System.out.print(root.val+" ");
            print(root.right,k1,k2);
        }
        else if(root.val > k2){
            print(root.left,k1,k2);
        }else{
            print(root.right,k1,k2);
        }
    }
    public static List<List<Integer>> rootToPath(Node root,List<Integer> ar,List<List<Integer>> ans){
        if(root == null){
            ans.add(ar);
            System.out.println(ar);
            return ans;
        }
        ar.add(root.val);
        rootToPath(root.left,ar,ans);
        rootToPath(root.right,ar,ans);
        ans.remove(ans.size()-1);
        return ans;
    }
    public static boolean isValidBst(Node root,Node min,Node max){
        if(root == null){
            return true;
        }
        if(min!=null && min.val>=root.val){
            return false;
        }else if(max!=null && max.val < root.val){
            return false;
        }else{
            return isValidBst(root.left,min,root) && isValidBst(root.right,root,max);
        }
    }
    public static Node mirrorBinary(Node root){
        if(root == null){
            return root;
        }
        if(root.left!=null  && root.right!=null){
            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        else if(root.left!=null){
            root.right=root.left;
            root.left=null;
        }else if(root.right!=null){
            root.left=root.right;
            root.right=null;
        }
        mirrorBinary(root.left);
        mirrorBinary(root.right);
        return root;
    }
    public static void main(String[] args) {
        int []arr={5,7,4,8,3,9,2,6,1,0};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=insert(root,arr[i]);
        }
        //inorder(root);
        //System.out.println(search(root, 11));
        //root=delete(root,8);
        //inorder(root);
        //print(root,2,9);
        // List<Integer> ar=new ArrayList<Integer>();
        // List<List<Integer>> ans=new ArrayList<List<Integer>>();
        // ans=rootToPath(root,ar,ans);
        // System.out.println(ans);
        // System.out.println(isValidBst(root, null, null));
        inorder(root);
        inorder(mirrorBinary(root));
    }
    
}
