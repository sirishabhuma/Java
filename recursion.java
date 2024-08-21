public class recursion {
    public static void main(String[] args) {
        increasingOrder(5);
        System.out.println();
        decreasingOrder(5);
        System.out.println();
        increasingOrder1(1);
        System.out.println();
        System.out.println(factorial(5));
        System.out.println(sumOfNaturals(5));
        System.out.println(fibnacci(5));
        int []arr={1,2,3,6,5,6,6};
        System.out.println(isSorted(arr,0));
        System.out.println(firstOccurance(arr,0,100));
        System.out.println(lastOccurance(arr,0,6));
        System.out.println(power(2,10));
        System.out.println(powerInLogn(2,10));
        System.out.println(tilingProblem(5));
        StringBuilder sb=new StringBuilder();
        boolean []b=new boolean[26];
        removeDuplicates("rich",0,sb,b);
        System.out.println(noOfWays(3));
        System.out.println(binaryNumber(3,"",0));
        recursiveOccurances(arr,0,6 );
        System.out.println();
        printNumber(2019);
        System.out.println();
        System.out.println(length("richards",0,0));
    }
    public static void increasingOrder(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        increasingOrder(n-1);
        System.out.print(n+" ");
    }
    public static void decreasingOrder(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        decreasingOrder(n-1);
    }
    public static void increasingOrder1(int n){
        if(n == 5){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        increasingOrder1(n+1);
    }
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int sumOfNaturals(int n){
        if(n==1){
            return 1;
        }
        return n+sumOfNaturals(n-1);
    }
    public static int fibnacci(int n){
        if(n == 0 || n==1){
            return n;
        }
        else if(n>1){
            return fibnacci(n-1)+fibnacci(n-2);
        }else{
            return 0;
        }
    }
    public static boolean isSorted(int arr[],int index){
        if(index == arr.length-1){
            return true;
        }
        if(arr[index] > arr[index+1]){
            return false;
        }
        return isSorted(arr,index+1);
    }
    public static int firstOccurance(int []arr,int i,int key){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurance(arr,i+1,key);
    }
    public static int lastOccurance(int []arr,int i,int key){
        if(i == arr.length){
            return -1;
        }
        int isFound=lastOccurance(arr,i+1,key);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }
    public static int power(int x,int n){
        if(n == 0){
            return 1;
        }
        return x*power(x,n-1);
    }
    public static int powerInLogn(int x,int n){
        if(n == 0){
            return 1;
        }
        if(n%2 == 0){
            int half=powerInLogn(x,n/2);
            return half*half;
        }else{
            int half=powerInLogn(x,n/2);
            return x*half*half;
        }
    }
    //important amazon
    public static int tilingProblem(int n){
        if(n==0 || n==1){
            return 1;
        }
        int vertical=tilingProblem(n-1);
        int horizontal=tilingProblem(n-2);
        return vertical+horizontal;
    }
    public static void removeDuplicates(String  str,int index,StringBuilder sb,boolean []map){
        if(index == str.length()){
            System.out.println(sb);
            return;
        }
        char c=str.charAt(index);
        if(map[c-'a'] == true){
            removeDuplicates(str,index+1,sb,map);
        }else{
            map[c-'a']=true;
            removeDuplicates(str,index+1,sb.append(c),map);
        }
    }
    public static int noOfWays(int n){
        if(n == 1 || n == 2 || n==0 ){
            return n;
        }
        int singleways=noOfWays(n-1);
        int pairways=noOfWays(n-2);
        int noOfPairWays=(n-1)*pairways;
        return singleways+noOfPairWays;
    }
    public static String binaryNumber(int n,String str,int lastplace){
        if(n == 0){
            System.out.println(str);
            return str;
        }
        binaryNumber(n-1,str+"0",0);
        if(lastplace == 0){
            binaryNumber(n-1,str+"1",1);
        }
        return str;
    }
    public static void  recursiveOccurances(int []arr,int index,int key){
        if(index == arr.length){
            return;
        }
        if(arr[index] == key){
            System.out.print(index+" ");
            recursiveOccurances(arr,index+1,key);

        }else{
            recursiveOccurances(arr,index+1,key);
        }
    } 
    public static void printNumber(int n){
        if(n <= 0){
            return;
        }
        String []arr={"zero","one","two","three","four","five","six","seven","eight","nine"};
        int res=n%10;
        n=n/10;
        printNumber(n);
        System.out.print(arr[res]+" ");
    }
    public static int length(String s,int length,int i){
        if(s.length()+1 == i ){
            return length;
        }
        return length(s,length++,i++); 
    }
}

