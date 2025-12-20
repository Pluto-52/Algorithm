package Search;

public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt=new Sqrt();
        int x=8;
        System.out.println(sqrt.mySqrt(x)); // 输出: 2
    }
    private int mySqrt(int x){
        if(x==0)return 0;
        int left=1;
        int right=x;
        while(left<=right){
            int mid=left+right>>1;
            if(mid<=x/mid){
                if((mid+1)>x/(mid+1)){
                    return mid;
                }
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
