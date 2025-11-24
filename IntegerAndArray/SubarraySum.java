package IntegerAndArray;

import java.util.*;
import java.lang.Integer;

public class SubarraySum {
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

        System.out.print("请输入目标和：");
        int target = 0;
        try {
            target = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入的目标和无效，使用默认值0");
        }

        int[] array = numbers.stream().mapToInt(java.lang.Integer::intValue).toArray();
        System.out.println("输入的数组为: " + Arrays.toString(array));
        System.out.println("和为k: " + target);
        System.out.println("子数组数量为: " + subarraySum(array, target));
    }
    public static int subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);
        int count=0;
        int sum=0;
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[ right];
            count+=sumToCount.getOrDefault(sum-target,0);
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
