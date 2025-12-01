package String;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(lengthOfLongestSubstring(s));
    }
//    public static int lengthOfLongestSubstring(String s) {
//        if(s.isEmpty())return 0;
//        int count =0;
//        int []nums=new int [26];
//        int i=0,j=0;
//        while(i<s.length()){
//            if(j<s.length()&&nums[s.charAt(j)-'a']==0){
//                nums[s.charAt(j++)-'a']++;
//                count=Math.max(count,j-i);
//            }
//            else{
//                nums[s.charAt(i++)-'a']--;
//            }
//        }
//        return count;
//    }
        public static int lengthOfLongestSubstring(String s) {
            // 添加 null 检查
            if (s == null || s.isEmpty()) return 0;

            // 使用 HashSet 替代固定大小数组，支持所有字符
            Set<Character> seen = new HashSet<>();
            int left = 0, maxLength = 0;

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);

                // 如果遇到重复字符，移动左指针直到没有重复
                while (seen.contains(currentChar)) {
                    seen.remove(s.charAt(left));
                    left++;
                }

                seen.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
}
