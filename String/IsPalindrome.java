package String;

import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(!Character.isLetterOrDigit(c1)){
                i++;
            }
            else if(!Character.isLetterOrDigit(c2)){
                j--;
            }
            else {
                c1=Character.toLowerCase(c1);
                c2=Character.toLowerCase(c2);
                if(c1!=c2)return false;
                i++;
                j--;
            }
        }
        return true;
    }
}
