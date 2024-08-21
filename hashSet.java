import java.util.*;
public class hashSet {
    public static void main(String[] args) {
        HashSet <ArrayList>hs=new HashSet<>();
        ArrayList <Integer>ar=new ArrayList<>();
        for(int i=0;i<10;i++){
            ar.add(i);
        }
        hs.add(ar);
        //System.out.println(hs);
        ArrayList <Integer>ar1=new ArrayList<>();
        for(int i=0;i<5;i++){
            ar1.add(i);
        }
        hs.add(ar1);
        System.out.println(hs);
        //iterator(hs);
        TreeSet <Integer>ts=new TreeSet<>();
        for(int i=10;i>=0;i--){
            System.out.print(i+" ");
            ts.add(i);
        }
        System.out.println(ts);
        int []arr1=new int[5];
        arr1[0]=1;
        arr1[1]=1;
        arr1[2]=1;
        arr1[3]=1;
        arr1[4]=1;
        int []arr2=new int[5];
        arr2[0]=2;
        arr2[1]=2;
        arr2[2]=2;
        arr2[3]=2;
        arr2[4]=2;
        //union(arr1,arr2);
        itenary();
        int []arr3={15,2,-2,-8,1,7,10,23};
        System.out.println(subArraySum(arr3));
    }
    public static void iterator(HashSet <ArrayList>hs){
        System.out.println("iterator");
        Iterator i=hs.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        //for each
        for(ArrayList <Integer>j: hs){
            System.out.println(j);
        }
    }
    public static void union(int []arr1,int []arr2){
        HashSet <Integer>hs=new HashSet<>();
        int j;
        boolean b=true;
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            hs.add(arr2[i]);
        }
        System.out.println(hs);
    }
    public static String startingPoint(HashMap <String,String>hs){
        HashMap <String,String>revMap=new HashMap<>();
        for(String to : hs.keySet()){
            System.out.println(to + " --> "+hs.get(to));
            revMap.put(hs.get(to),to);
        }
        for(String from : hs.keySet()){
            if(!revMap.containsKey(from)){
                return from;
            }
        }
        return null;
    }
    public static void itenary(){
        HashMap <String,String>hs=new HashMap<>();
        hs.put("chennai","banguluru");
        hs.put("mumbai","delhi");
        hs.put("goa","chennai");
        hs.put("delhi","goa");
        String start=startingPoint(hs);
        System.out.println(start);
        for(String s : hs.keySet()){
            System.out.print(start+" --> "+hs.get(start)+" ");
            start=hs.get(start);
        }
    }
    public static int subArraySum(int []arr){
        HashMap <Integer,Integer> hs=new HashMap<>();
        int ans=-1;
        int sum=0;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(hs.containsKey(sum)){
                ans=j-hs.get(sum);
            }else{
                hs.put(sum,j);
            }
        }
        return ans;
    }
}
