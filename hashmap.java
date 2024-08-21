import java.util.*;
public class hashmap<k,v> {
    public static void main(String[] args) {
        HashMap <String,String>hm=new HashMap<>();
        hm.put("bec","bapatla");
        hm.put("rvrjc","guntoor");
        System.out.println(hm.get("bec"));
        hm.put("vr siddartha","vijayawada");
        System.out.println(hm.containsKey("bec"));
        System.out.println(hm.remove("bec"));
        System.out.println(hm);
        hm.put("bec","bapatla");
        System.out.println(hm.size());
        Set <String>s=hm.keySet();
        System.out.println(s);
        for(String k:s){
            System.out.println(hm.get(k)+" ");
        }
        for(Map.Entry<String,String> m : hm.entrySet()){
            System.out.println(m);
        }
        linkedhashmap();    
    }
    public static void linkedhashmap(){
        LinkedHashMap <String,String>hm=new LinkedHashMap<>();
        hm.put("bec","bapatla");
        hm.put("rvrjc","guntoor");
        System.out.println(hm);
    }
}
