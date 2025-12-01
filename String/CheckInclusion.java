package String;

import java.util.Scanner;

public class CheckInclusion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int [] counts=new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)-'a']++;
            counts[s2.charAt(i)-'a']--;
        }
        if(areAllZeros(counts)){
            return true;
        }
        for(int i =s1.length();i<s2.length();i++){
            counts[s2.charAt(i)-'a']--;
            counts[s2.charAt(i-s1.length())-'a']++;
            if(areAllZeros(counts)){
                return true;
            }
        }
        return false;
    }
    public static boolean areAllZeros(int [] counts){
        for (int count : counts) {
            if(count!=0)return false;
        }
        return true;
    }
}
