package Tree;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    private TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> lower = calendar.floorEntry(start);
        if(lower!=null&&lower.getValue()>start){
            return false;
        }
        Map.Entry<Integer,Integer> higher=calendar.ceilingEntry(start);
        if(higher!=null&&higher.getKey()<end){
            return false;
        }
        calendar.put(start,end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // 返回 true
        System.out.println(myCalendar.book(15, 25)); // 返回 false，因为时间段 [15, 25) 与之前的预订 [10, 20) 重叠
        System.out.println(myCalendar.book(20, 30)); // 返回 true，时间段 [20, 30) 不与之前的预订重叠
    }
}
