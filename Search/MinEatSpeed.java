package Search;

public class MinEatSpeed {
    public static void main(String[] args) {
        MinEatSpeed mes=new MinEatSpeed();
        int[] piles={3,6,7,11};
        int h=8;
        System.out.println(mes.minEatingSpeed(piles,h)); // 输出: 4
    }

    public int minEatingSpeed(int[] piles, int h) {
        int right=1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int left=1;
        while(left<=right){
            int mid=left+right>>1;
            if(getHours(piles,mid)<=h){
                if(mid==1||getHours(piles,mid-1)>h){
                    return mid;
                }
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
    private int getHours(int[] piles,int speed){
        int hours=0;
        for (int pile : piles) {
            hours+=(pile+speed-1)/speed;
        }
        return hours;
    }
}
