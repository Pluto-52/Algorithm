package search;

import java.util.Random;

public class Solution {
    private int []nums;
    private int total;
    public Solution(int[] w){
        this.nums=new int [w.length];
        int sum=0;
        for (int i = 0; i < w.length; i++) {
            sum+=w[i];
            this.nums[i]=sum;
        }
        this.total=sum;
    }

    public int pickIndex(){
        Random random=new Random();
        int target=random.nextInt(total)+1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+right>>1;
            if(nums[mid]==target)return mid;
            else if(nums[mid]<target){
                left=mid+1;
            }else{
                if(mid==0||nums[mid-1]<target){
                    return mid;
                }
                right=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] w = {1,2,3,4};
        Solution solution = new Solution(w);
        // 测试 pickIndex 方法
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.pickIndex());
        }
    }
}
