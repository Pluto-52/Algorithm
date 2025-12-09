package HashTable;

import java.util.Scanner;

public class IsAlienSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");
        String order = sc.nextLine();
        System.out.println(isAlienSorted(words, order));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        int []orderArray=new int[order.length()];
        for (int i = 0; i < order.toCharArray().length; i++) {
            orderArray[order.charAt(i)-'a']=i;
        }
        for (int i = 0; i < words.length-1; i++) {
            if(!isSorted(words[i],words[i+1],orderArray))return false;
        }
        return true;
    }
    public static boolean isSorted(String word1,String word2,int[]orderArray){
        int i=0;
        for(;i<word1.length()&&i<word2.length();i++){
            char c1=word1.charAt(i);
            char c2=word2.charAt(i);
            if(orderArray[c1-'a']>orderArray[c2-'a'])return false;
            if(orderArray[c1-'a']<orderArray[c2-'a'])return true;
        }
        return i==word1.length();
    }
}
