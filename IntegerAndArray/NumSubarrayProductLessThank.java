package IntegerAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumSubarrayProductLessThank {
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

        System.out.print("请输入目标积：");
        int target = 0;
        try {
            target = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入的目标和无效，使用默认值0");
        }

        int[] array = numbers.stream().mapToInt(java.lang.Integer::intValue).toArray();
        System.out.println("输入的数组为: " + Arrays.toString(array));
        System.out.println("乘积小于k: " + target);
        System.out.println("子数组数量为: " + numSubarrayProductLessThank(array, target));
    }
    public static int numSubarrayProductLessThank(int[] nums, int target) {
        int left=0;
        int product=1;
        int count=0;
        for (int right = 0; right < nums.length; right++) {
            product*=nums[right];
            while(left<right&&product>=target){
                product/=nums[left++];
            }
            count+=right-left+1;
        }
        return count;
    }
}
