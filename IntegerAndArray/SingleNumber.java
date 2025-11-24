package IntegerAndArray;

import java.util.Scanner;

public class SingleNumber {
    //数组中只有一个数组出现m次，其它数字出现n次，找出这个数字（m不能被n整除）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 获取数组大小
        System.out.print("请输入数组大小: ");
        int size = scanner.nextInt();

        // 创建并填充数组
        int[] nums = new int[size];
        System.out.println("请输入 " + size + " 个整数:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // 获取m和n值
        System.out.print("请输入m (目标出现次数): ");
        int m = scanner.nextInt();
        System.out.print("请输入n (其他数字出现次数): ");
        int n = scanner.nextInt();

        // 验证约束条件
        if (m % n == 0) {
            System.out.println("错误: m 必须不能被 n 整除");
            return;
        }
        int result = singleNumber(nums, m, n);
        System.out.println(result);
    }

    private static int singleNumber(int[] array, int m, int n) {
        int []count=new int[32];
        for (int num : array) {
            for (int i = 0; i < 32; i++) {
                count[i]+=(num>>(31-i))&1;
            }
        }
        int result=0;
        for (int i = 0; i < count.length; i++) {
            if(count[i]%n!=0){
                result|=1<<(31-i);
            }
        }
        return result;
    }
}
