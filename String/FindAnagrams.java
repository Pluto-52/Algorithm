package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
       List<Integer> res=new ArrayList<>();
       int []nums=new int [26];
        for (char c : s.toCharArray()) {
            nums[c-'a']++;
        }
        for (int i = 0; i < p.toCharArray().length; i++) {
            if(i<s.length())nums[p.charAt(i)-'a']--;
            else {
                nums[p.charAt(i)-'a']--;
                nums[p.charAt(i-s.length())-'a']++;
            }
            if(areAllZero(nums)){
                res.add(i-s.length()+1);
            }
        }
        return res;
    }
    public static boolean areAllZero(int []nums){
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}
