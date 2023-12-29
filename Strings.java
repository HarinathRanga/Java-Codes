import java.util.*;
public class Strings{
    public static boolean isPalindrome(String str){
        int n=str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public static float minDistance(String str) {
        int x=0,y=0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='S'){
                y--;
            }
            else if(str.charAt(i)=='N') {
                y++;
            }
            else if(str.charAt(i)=='W') {
                x--;
            }
            else{
                x++;
            }
        }
        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);

    }
    public static String compress(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str="ApnaCollege".replace("l","");
        System.out.println(str);
    }
}