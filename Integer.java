import java.util.Scanner;
//1
public class Integer {
    private static final int MAX_VALUE = 0x7fffffff;

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int dividend=sc.nextInt();
//        int divisor=sc.nextInt();
//        int result = divide(dividend, divisor);
//        System.out.println(result);
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter dividend (or 'quit' to exit): ");
                if (sc.hasNextInt()) {
                    int dividend = sc.nextInt();
                    System.out.print("Enter divisor: ");
                    int divisor = sc.nextInt();
                    int result = divide(dividend, divisor);
                    System.out.println("Result: " + result);
                } else {
                    String input = sc.next();
                    if (input.equalsIgnoreCase("quit")) {
                        break;
                    }
                    System.out.println("Invalid input. Please enter integers only.");
                }
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
                sc.nextLine(); // Clear the invalid input
            }
        }
    }
    public static int divide(int dividend, int divisor) {
        if(dividend==0x80000000 && divisor==-1){
            return Integer.MAX_VALUE;
        }
        int negative=2;
        if(dividend<0){
            dividend=-dividend;
            negative--;
        }
        if(divisor<0){
            divisor=-divisor;
            negative--;
        }
        int result=divideCore(dividend, divisor);
        return negative ==1 ? -result : result;

    }
    public static int divideCore(int dividend, int divisor) {
        int result=0;
        while(dividend>=divisor){
           int value=divisor;
           int quotient=1;
           while(value>0 && dividend>=value+value){
               value+=value;
               quotient+=quotient;
           }
           dividend-=value;
           result+=quotient;
        }
        return result;
    }
}


