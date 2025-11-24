package IntegerAndArray;

import java.util.*;
import java.lang.Integer;

public class FindMaxLength {

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
        System.out.println("0和1个数相同的最长连续子数组长度" + findMaxLength(array) );
    }
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex=new HashMap<>();
        sumToIndex.put(0,-1);
        int sum=0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i]==0?-1:1;
            if(sumToIndex.containsKey(sum)){
                count=Math.max(count,i-sumToIndex.get(sum));
            }
            else{
                sumToIndex.put(sum,i);
            }
        }
        return count;
    }
}
