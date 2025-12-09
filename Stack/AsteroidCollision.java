package Stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids={4,5,-6,4,8,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for (int i : asteroids) {
            while(!stack.empty()&&stack.peek()>0&&stack.peek()<-i){
                stack.pop();
            }
            if(!stack.empty()&&i<0&&stack.peek()==-i){
                stack.pop();
            }
            else if(stack.empty()||stack.peek()<0||i>0){
                stack.push(i);
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
