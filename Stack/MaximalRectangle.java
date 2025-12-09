package Stack;

import static Stack.LargestRectangleArea.largestRectangleArea2;

public class MaximalRectangle {
    public static void main(String[] args) {
        int [][] matrix= {{1,0,1,0,0},{0,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)return 0;
        int[] height=new int[matrix[0].length];
        int area=0;
        for (int[] i : matrix) {
            for (int j = 0; j < i.length; j++) {
                if(i[j]==0)height[j]=0;
                else height[j]++;
            }
            area=Math.max(area, largestRectangleArea2(height));
        }
        return area;
    }
}
