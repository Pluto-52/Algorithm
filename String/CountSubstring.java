package String;

import java.util.Scanner;

public class CountSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(countSubstring(s));
    }
    public static int countSubstring(String s) {
        if(s==null||s.isEmpty())return 0;
        int count=0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            count+=countPalindrome(s,i,i);
            count+=countPalindrome(s,i,i+1);
        }
        return count;
    }
    public static int countPalindrome(String s,int left,int right){
        int count=0;
        while(left>=0&&right<=s.length()-1&&s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
