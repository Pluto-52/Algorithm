package Heap;

import java.util.*;

public class KSmallestPairs {
    public static void main(String[] args) {
        int[] nums1={1,7,11,18,19,20};
        int[] nums2={2,4,6,9,10,87};
        int k=3;
        System.out.println(kSmallestPairs2(nums1,nums2,k));
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(
                (a,b)->(b[0]+b[1])-(a[0]+a[1])
        );
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(maxHeap.size()<k){
                    maxHeap.offer(new int[]{nums1[i],nums2[j]});
                }else{
                    int sum=nums1[i]+nums2[j];
                    if(sum<maxHeap.peek()[0]+maxHeap.peek()[1]){
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i],nums2[j]});
                    }
                }
            }
        }
        List<List<Integer>> res=new LinkedList<>();
        while(!maxHeap.isEmpty()){
            int[] pair=maxHeap.poll();
            res.add(Arrays.asList(pair[0],pair[1]));
        }
        return res;
    }
    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap=new PriorityQueue<>(
                (a,b)->(nums1[a[0]]+nums2[a[1]]-(nums1[b[0]]+nums2[b[1]]))
        );
        if(nums2.length>0){
            for (int i = 0; i < Math.min(nums1.length, k); i++) {
                minHeap.offer(new int[]{i,0});
            }
        }
        List<List<Integer>> res=new LinkedList<>();
        while(k-->0&&!minHeap.isEmpty()){
            int[]ids=minHeap.poll();
            res.add(Arrays.asList(nums1[ids[0]],nums2[ids[1]]));
            if(ids[1]<nums2.length-1){
                minHeap.offer(new int[]{ids[0],ids[1]+1});
            }
        }
        return res;
    }

}
