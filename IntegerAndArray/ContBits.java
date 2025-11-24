package IntegerAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Integer;
public class ContBits {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("请输入整数（输入非整数结束输入）：");

        // 循环读取输入直到输入非整数
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            numbers.add(number);
            System.out.println("已添加: " + number);
        }

        // 将ArrayList转换为数组
        int[] array = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            array[i] = numbers.get(i);
        }
        int[] result = contBits(array);
        System.out.println("您输入的数组: " + Arrays.toString( array));
        System.out.println("结果为："+ Arrays.toString(result));
    }
    public static int[] contBits(int[] array){
        int []result=new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int j=array[i];
            while(j>0){
                j&=(j-1);
                result[i]++;
            }
        }
        return result;
    }
}
