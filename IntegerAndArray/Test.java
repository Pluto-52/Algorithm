package IntegerAndArray;

import java.util.*;
import java.lang.Integer;
public class Test {
    public static void main(String[] args) {
        //输入一个整数数组和一个整数k，求数组中和大于等于k的连续子数组的最小长度
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
        System.out.println("大于或等于k: " + target);
        System.out.println("最小的连续子数组长度为: " + test(array, target));
    }
    public static int test(int[] nums, int target) {
//        int n = nums.length;
//        long[] prefixSum = new long[n + 1]; // 修正：使用long类型数组
//
//        // 计算前缀和数组
//        for (int i = 0; i < n; i++) {
//            prefixSum[i + 1] = prefixSum[i] + nums[i];
//        }
//
//        int minLength = IntegerAndArray.Integer.MAX_VALUE;
//        // 使用TreeMap维护前缀和及其索引，保持按键排序
//        TreeMap<Long, IntegerAndArray.Integer> map = new TreeMap<>(); // 修正：key使用Long类型
//        map.put(0L, -1); // 处理从索引0开始的子数组
//
//        for (int i = 0; i < n; i++) {
//            long currentSum = prefixSum[i + 1];
//
//            // 查找满足条件的最大前缀和：prefixSum[j] <= currentSum - target
//            Long floorKey = map.floorKey(currentSum - target); // 修正：变量名避免冲突
//            if (floorKey != null) {
//                int index = map.get(floorKey);
//                minLength = Math.min(minLength, i - index);
//            }
//
//            // 将当前前缀和加入TreeMap
//            map.put(currentSum, i);
//        }
        int minLength=Integer.MAX_VALUE;
        int []sum = new int[nums.length];
        sum[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i]=sum[i-1]+nums[i];
        }
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,-1);
        for (int i = 0; i < sum.length; i++) {
            if(map.floorKey(sum[i]-target)!=null){
                minLength=Math.min(minLength,i-map.get(map.floorKey(sum[i]-target)));
            }
            map.put(sum[i],i);
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
