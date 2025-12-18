package search;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int left=0;
        int right=nums.length/2;
        while(left<=right){
            int mid=left+right>>2;
            int i=mid*2;
            if(i<nums.length-1&&nums[i]!=nums[i+1]){
                if(i==0||nums[i-2]==nums[i-1]){
                    return i;
                }
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        SingleNonDuplicate snd=new SingleNonDuplicate();
        int[] nums={1,1,2,3,3,4,4,8,8};
        System.out.println(snd.singleNonDuplicate(nums)); // 输出: 2
    }
}
