package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int capacity=0;
    int sum=0;
    Queue< Integer> nums;
    public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(3);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }
    public MovingAverage(int capacity) {
        this.nums = new LinkedList<>();
        this.capacity = capacity;
    }
    public double next(int val) {
        nums.offer(val);
        sum+=val;
        if(nums.size()>capacity){
            sum-=nums.poll();
        }
        return (double)sum/nums.size();
    }
}
