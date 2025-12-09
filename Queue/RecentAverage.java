package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentAverage {
    Queue<Integer> queue;
    int time;
    public RecentAverage(int time){
        queue = new LinkedList<>();
        this.time = time;
    }
    public int ping(int t){
        queue.offer(t);
        while(time+queue.peek()<t){
            queue.poll();
        }
        return queue.size();
    }
    public static void main(String[] args) {
        RecentAverage obj = new RecentAverage(3000);
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
        System.out.println(obj.ping(3003));
        System.out.println(obj.ping(3004));
    }
}

