package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int []temperatures={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int []res=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.empty()&&temperatures[i]>temperatures[stack.peek()]){
                int pre=stack.pop();
                res[pre]=i-pre;
            }
            stack.push(i);
        }
        return res;
    }
}
