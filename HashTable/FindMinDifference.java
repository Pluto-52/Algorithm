package HashTable;

import java.util.List;
import java.util.TreeSet;

public class FindMinDifference {
    public static void main(String[] args) {
        List<String> timePoints = List.of(new String[]{"23:59", "23:50", "00:00"});
        System.out.println(findMinDifference2(timePoints));
    }
    public static int findMinDifference(List<String> timePoints) {
        if(timePoints.size()>24*60)return 0;
        boolean []minuteFlag=new boolean[24*60];
        for (String time : timePoints) {
            String[] minute = time.split(":");
            int timeMinute=Integer.parseInt(minute[0])*60+Integer.parseInt(minute[1]);
            if(minuteFlag[timeMinute])return 0;
            minuteFlag[timeMinute]=true;
        }
        return helper(minuteFlag);
    }
    public static int helper(boolean[] minuteFlag){
        int pre=-1;
        int min= minuteFlag.length-1;
        int max= -1;
        int res=minuteFlag.length-1;
        for (int i = 0; i < minuteFlag.length; i++) {
            if(minuteFlag[i]){
                if(pre>0){
                    res=Math.max(res,i-pre);
                }
                pre=i;
                min=Math.min(min,i);
                max=i;
            }
        }
        return Math.min(res,min+minuteFlag.length-max);
    }
    public static int findMinDifference2(List<String> timePoints) {
        TreeSet<Integer> minuteFlag=new TreeSet<>();
        for (String time : timePoints) {
            int timeMinute=Integer.parseInt(time.substring(0,2))*60+Integer.parseInt(time.substring(3));
            if(minuteFlag.contains(timeMinute))return 0;
            minuteFlag.add(timeMinute);
        }
        return helper2(minuteFlag);
    }
    public static int helper2(TreeSet<Integer> minuteFlag){
        int pre=-1;
        int res=minuteFlag.first()+24*60-minuteFlag.last();
        for (int i : minuteFlag) {
            if(pre>0)res=Math.min(res,i-pre);
            pre=i;
        }
        return res;
    }
}
