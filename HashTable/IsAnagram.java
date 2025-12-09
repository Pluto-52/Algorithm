package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsAnagram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        System.out.println(isAnagram(s, t));
    }

    /**
     * 如果输入字符只包含英文小写字母
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] count=new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            if(count[c-'a']==0)return false;
            count[c-'a']--;
        }
        return true;
    }
    /**
     * 如果输入字符包含非英文字符
     */
    public static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Integer>map=new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : t.toCharArray()) {
            if(!map.containsKey(c)||map.get(c)==0)return false;
            map.put(c,map.get(c)-1);
        }
        return true;
    }
}
