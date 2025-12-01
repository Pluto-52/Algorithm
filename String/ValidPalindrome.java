package String;

import java.util.Scanner;

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(validPalindrome(s));
    }

    private static boolean validPalindrome(String s) {
        int start=0,end=s.length()-1;
        while(start<s.length()/2){
            if(s.charAt(start)!=s.charAt(end))break;
            start++;
            end--;
        }
        return start==s.length()/2
                || isPalindrome(s.substring(start+1,end))
                || isPalindrome(s.substring(start,end-1));
    }

    public static boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))break;
            start++;
            end--;
        }
        return start>=end;
    }
}
