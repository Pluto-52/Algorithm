package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums1={1,2,3,1};
        int k1=3;
        int t1=0;
        System.out.println(containsNearbyAlmostDuplicate2(nums1,k1,t1)); // true
        int[] nums2={1,5,9,1,5,9};
        int k2=2;
        int t2=3;
        System.out.println(containsNearbyAlmostDuplicate2(nums2,k2,t2)); // false
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer lower=treeSet.floor(nums[i]);
            if(lower!=null&&nums[i]-t<=lower)return true;
            Integer higher=treeSet.ceiling(nums[i]);
            if(higher!=null&&nums[i]+t>=higher)return true;
            treeSet.add(nums[i]);
            if(i>=k){
                treeSet.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        Map<Integer,Integer> map=new HashMap<>();
        int bucketSize=t+1;
        for (int i = 0; i < nums.length; i++) {
            int id=getBucketId(nums[i],bucketSize);
            if(map.containsKey(id)
                    ||(map.containsKey(id-1)&&nums[i]-t<=map.get(id-1))
                    ||(map.containsKey(id+1)&&nums[i]+t>=map.get(id+1))
            )return true;
            map.put(id,nums[i]);
            if(i>=k){
                map.remove(getBucketId(nums[i-k],bucketSize));
            }
        }
        return false;
    }
    private static int getBucketId(int num,int bucketSize){
        return num>=0?num/bucketSize:(num+1)/bucketSize-1;
    }
}
