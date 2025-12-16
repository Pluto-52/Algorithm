package Heap;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        int k=2;
        List<Integer> res=topKFrequent(nums,k);
        System.out.println(res);
    }

    public static List<Integer> topKFrequent(int[]nums,int k){
        Map<Integer,Integer> freqMap=new HashMap<>();
        Queue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>(
                (a,b)->a.getValue()-b.getValue()
//                Comparator.comparingInt(Map.Entry::getValue)
        );
        for (int num : nums) {
           freqMap.put(num,freqMap.getOrDefault(num,0)+1);
            }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(minHeap.size()<k){
                minHeap.offer(entry);
            }else {
                if(entry.getValue()>minHeap.peek().getValue()){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        List<Integer> res=new LinkedList<>();
        while(!minHeap.isEmpty()){
            res.add(minHeap.poll().getKey());
        }
        return res;
    }
}
