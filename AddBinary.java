import java.util.Scanner;

public class AddBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String s = addBinary(a, b);
        System.out.println(s);
    }
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() ;
        int j = b.length() ;
        int carry = 0;
        while(i>0 ||j>0){
            int digitA=i>0?a.charAt(--i)-'0':0;
            int digitB=j>0?b.charAt(--j)-'0':0;
            int sum=digitA+digitB+carry;
            carry=sum>=2?1:0;
            sum=sum>=2?sum-2:sum;
            res.append(sum);
        }
        if(carry==1){
            res.append(carry);
        }
        return res.reverse().toString();
    }

}
