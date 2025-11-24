package IntegerAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.Integer;
public class ThreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("请输入数组元素（用空格分隔）：");

        // 读取一整行输入并解析
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");

        for (String part : parts) {
            try {
                if (!part.isEmpty()) {
                    numbers.add(Integer.parseInt(part));
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

        int[] array = numbers.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("输入的数组为: " + Arrays.toString(array));
        System.out.println("目标和为: " + target);

        scanner.close();
        List<List<Integer>> result=threeSum(array,target);
        result.forEach(System.out::println);
    }

    private static List<List<Integer>> threeSum(int[] array, int target) {
        List<List<Integer>> result=new ArrayList<>();

        if (array.length>=3) {
            Arrays.sort(array);
            int i=0;
            while (i<array.length-2) {
                while(i<array.length-2&&array[i]==array[i+1])i++;
                int j=0;
                int k=array.length-1;
                while(j<k){
                    while(j<k&&array[j]==array[j+1])j++;
                    if(array[i]+array[j]+array[k]==target){
                        result.add(Arrays.asList(array[i],array[j],array[k]));
                        j++;
                    }
                    else if(array[i]+array[j]+array[k]<target){
                        j++;
                    }
                    else{
                        k--;
                    }
                }
                i++;
            }
        }
        return result;
    }
}
