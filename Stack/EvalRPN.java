package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        System.out.println("输入的字符数组"+ Arrays.toString(s));
        System.out.println(evalRPN(s));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer>  stack=new Stack<>();
        for (String s : tokens) {
            switch(s){
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1=stack.pop();
                    int num2=stack.pop();
                    stack.push(calculate(num1,num2,s));
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public static int calculate(int num1,int num2,String s){
        return switch (s) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }
}
