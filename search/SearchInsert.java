package search;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
       int left=0;
       int right=nums.length-1;
       while(left<=right){
           int mid=(left+right)/2;
           if(nums[mid]<target){
                left=mid+1;
           }else{
               if(mid==0||nums[mid-1]<target){
                   return mid;
               }
               right=mid-1;
           }
       }
       return nums.length;
    }

    public static void main(String[] args) {
        SearchInsert si=new SearchInsert();
        int[] nums={1,3,5,6};
        int target=5;
        System.out.println(si.searchInsert(nums,target)); // 输出: 2
    }
}
