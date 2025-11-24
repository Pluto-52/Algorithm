package IntegerAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PivotIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<java.lang.Integer> numbers = new ArrayList<>();

        System.out.println("请输入数组元素（用空格分隔）：");

        // 读取一整行输入并解析
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");

        for (String part : parts) {
            try {
                if (!part.isEmpty()) {
                    numbers.add(java.lang.Integer.parseInt(part));
                }
            } catch (NumberFormatException e) {
                System.out.println("警告: 忽略无效输入 '" + part + "'");
            }
        }

        int[] array = numbers.stream().mapToInt(java.lang.Integer::intValue).toArray();
        System.out.println("输入的数组为: " + Arrays.toString(array));
        System.out.println("左右两边数组的和相等" + pivotIndex(array) );
    }

    private static int pivotIndex(int[] array) {
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        int leftSum=0;
        for (int i = 0; i < array.length; i++) {
            leftSum+=array[i];
            if(leftSum-array[i]==sum-leftSum)return i;
        }
        return -1;
    }
}
