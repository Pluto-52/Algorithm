package IntegerAndArray;

import java.util.Scanner;

public class MaxProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String []words=scanner.nextLine().split(" ");
        int result =maxProduct2(words);
        System.out.println(result);
    }


    //用哈希表记录字符串出现的个数
    private static int maxProduct1(String[] words) {
        boolean [][] flag=new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flag[i][c-'a']=true;
            }
        }
        int result=0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                int k=0;
                for (; k < 26; k++) {
                    if(flag[i][k]&&flag[j][k]){
                        break;
                    }
                }
                if(k==26){
                    result=Math.max(result,words[i].length()*words[j].length());
                }
            }
        }
        return result;
    }

    //用整数的二进制数位记录字符串出现的个数
    private static int maxProduct2(String[] words) {
        int []flag=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flag[i]|= 1<<(c-'a');
            }
        }
        int result=0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if((flag[i] & flag[j])==0){
                    break;
                }
                result=Math.max(result,words[i].length()*words[j].length());
            }
        }
        return result;
    }
}
