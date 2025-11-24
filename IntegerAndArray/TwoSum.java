package IntegerAndArray;

import java.util.*;
import java.lang.Integer;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("请输入数组元素，输入非数字结束：");

        // Properly handle non-integer input
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else {
                scanner.next(); // consume the invalid token
                break;
            }
        }
        System.out.print("请输入和：");
        int target = scanner.nextInt();
        Arrays.sort(numbers.toArray());
        System.out.println("输入的数组为"+ numbers);
        scanner.close();
        Map<Integer, Integer> result = twoSum(numbers, target);
        result.forEach((k,v)->System.out.println("numbers["+k+"]+numbers["+v+"]="+target));
        List<int[]> res = result.entrySet().stream().map(entry -> new int[]{entry.getKey(), entry.getValue()}).toList();
        res.forEach(arr-> System.out.println(Arrays.toString( arr)));
    }

    private static Map<Integer, Integer> twoSum(List<Integer> numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
            int i=0;
            int j=numbers.size()-1;
            while(i<j){
                if(numbers.get(i)+numbers.get(j)<target){
                    i++;
                }
                else if(numbers.get(i)+numbers.get(j)>target){
                    j--;
                }
                else{
                    map.put(i,j);
                    i++;
                    j--;
                }
            }
        return map;
    }
}
