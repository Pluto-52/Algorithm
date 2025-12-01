package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer,Integer> numToLocation;
    ArrayList<Integer> nums;
    public  RandomizedSet(){
        this.numToLocation=new HashMap<>();
        this.nums=new ArrayList<>();
    }
    public boolean insert(int val){
        if(numToLocation.containsKey(val))return false;
        numToLocation.put(val,nums.size());
        nums.add(val);
        return true;
    }
    public boolean remove(int val){
        if(!numToLocation.containsKey(val))return false;
        int location =numToLocation.get(val);
        numToLocation.put(nums.get(nums.size()-1),location);
        numToLocation.remove(val);
        nums.set(location,nums.get(nums.size()-1));
        nums.remove(nums.size()-1);
        return true;
    }
    public int getRandom(){
        Random random=new Random();
        int res = random.nextInt(nums.size() - 1);
        return nums.get(res);
    }
}
