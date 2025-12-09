package HashTable;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(strs));
    }
    public static  List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> groups=new HashMap<>();
        int []hash={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        for(String str:strs){
            int count=1;
            for (char c : str.toCharArray()) {
                count*=hash[c-'a'];
            }
            groups.putIfAbsent(count, new ArrayList<>());
            groups.get(count).add(str);
        }
        return new LinkedList<>(groups.values());
    }
    public static  List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> groups=new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
