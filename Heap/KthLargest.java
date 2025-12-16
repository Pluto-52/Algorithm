package Heap;

import java.util.PriorityQueue;

public class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

   public KthLargest(int k,int[]nums){
        this.k=k;
        minHeap=new PriorityQueue<>();
       for (int num : nums) {
           add(num);
       }
   }
    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.offer(val);
        }
        else if(val>minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // 返回 4
        System.out.println(kthLargest.add(5));   // 返回 5
        System.out.println(kthLargest.add(10));  // 返回 5
        System.out.println(kthLargest.add(9));   // 返回 8
        System.out.println(kthLargest.add(4));   // 返回 8
    }
}
