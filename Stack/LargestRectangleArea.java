package Stack;


import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        int []heights={3,2,5,4,6,1,4,2};
        System.out.println(largestRectangleArea2(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        return helper(heights,0,heights.length);
    }
    public static int helper(int[] heights,int start,int end){
        if(start==end)return 0;
        if(start+1==end)return 0;
        int minIndex=start;
        for (int i = start; i < end; i++) {
            if(heights[i]<heights[minIndex]){
                minIndex=i;
            }
        }
        int area=heights[minIndex]*(end-start);
        area=Math.max(area,helper(heights,start,minIndex));
        return Math.max(area,helper(heights,minIndex+1,end));
    }
    public static int largestRectangleArea2(int[] heights) {
        Stack< Integer> stack=new Stack<>();
        stack.push(-1);
        int area=0;
        for (int i = 0; i < heights.length; i++) {
            while(stack.peek()!=-1&&heights[i]<heights[stack.peek()]){
                int height=heights[stack.pop()];
                int width=i-stack.peek()-1;
                area=Math.max(area,height*width);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int height=heights[stack.pop()];
            int width=heights.length-stack.peek()-1;
            area=Math.max(area,height*width);
        }
        return area;
     }
}
