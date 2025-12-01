package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count=t.length();
        int left=0, right=0;
        int start=0,end=0;
        int minLength=Integer.MAX_VALUE;
        while(right<s.length()||(count==0&&right==s.length())){
            if(count>0){
                char c =s.charAt(right);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)-1);
                }
                if(map.get(c)==0)count--;
                right++;
            }
            else{
                if(right-left<minLength){
                       minLength=right-left;
                       start=left;
                       end=right;
                }
                char c =s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                    if(map.get(c)==1)count++;
                }
                left++;
            }
        }
        return minLength<Integer.MAX_VALUE?s.substring(start,end):"";
    }
}
