package Recursion;

public class Pallindrome_String {

    private static boolean  reverse(String str,int i){
        if(i>str.length()/2){
            return true;
        }
        if(str.charAt(i)==str.charAt(str.length()-i-1)){
            return reverse(str,i+1);
        }
        return false;
    }


    public static void main(String[] args) {
        String str="AabccbaA";
        System.out.println(reverse(str,0));
    }
}
