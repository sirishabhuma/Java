public class Strings {
    public static void main(String []args){
        String a="abc  %-=+.";
        System.out.println(a.length());
        pallindromeString();
        shortestPath();
        newString();
        startingUpperCase();
        stringCompression();
        noLower();
        Replace();
        stringequals();
    }
    public static void pallindromeString(){
        String a="malayalam";
        boolean b=false;
        for(int i=0;i<a.length()/2;i++){
            if(a.charAt(i) == a.charAt(a.length()-i-1)){
                b=true;
            }
        }
        if(b == true){
            System.out.println("palindrome");
        }else{
            System.out.println("not a palindrome");
        }
    }
    public static void shortestPath(){
        String s="wneenesennn";
        int x=0;
        int y=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'w'){
                x--;
            }else if(s.charAt(i) == 'e'){
                x++;
            }else if(s.charAt(i) == 'n'){
                y++;
            }else{
                y--;
            }
        }
        int a=(int)Math.pow((x),2);
        int b=(int)Math.pow((y),2);
        System.out.println((int)Math.sqrt(a+b));
    }
    public static void newString(){
        StringBuilder sb=new StringBuilder("");
        for(char a='a';a<='z';a++) {
            sb.append(a+" ");

        }
        System.out.println(sb);
    }
    public static void startingUpperCase(){
        String a="hi this is richards" ;
        StringBuilder sb=new StringBuilder();
        char c=Character.toUpperCase(a.charAt(0));
        sb.append(c);
        for(int i=1;i<a.length();i++){
            if(a.charAt(i) == ' ' && i < a.length()-1){
                sb.append(" ");
                i++;
                c=Character.toUpperCase(a.charAt(i));
                sb.append(c);
            }else{
                sb.append(a.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
    public static void stringCompression(){
        StringBuilder sb=new StringBuilder("abbccddeeff");
        StringBuilder sb1=new StringBuilder();
        for(int i=0;i<sb.length();i++){
            int count=1;
            while(i< sb.length()-1 && sb.charAt(i) == sb.charAt(i+1)){
                count++;
                i++;
            }
            sb1.append(sb.charAt(i));
            if(count > 0){
                sb1.append(count);
            }
        }
        System.out.println(sb1.toString());
    }
    public static void noLower(){
        int count=0;
        StringBuilder sb=new StringBuilder("A");
        char c='a';
        for(int i=0;i<sb.length();i++){
            c=sb.charAt(i);
            if(Character.isLowerCase(c)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static void Replace(){
        String sb=new String("Richards").intern();
        System.out.println(sb.replace("R",""));
    }
    public static void stringequals(){
        String a=new String("Richards").intern();
        String b=new String("Richards").intern();
        System.out.println(a == b);
        String c=new String("hello");
        String d="hello";
        String e=c.intern();
        System.out.println((e == d));
        System.out.println(" ");
        String f="abc";
        String g=new String("abc");
        if(f == g){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
