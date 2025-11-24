package IntegerAndArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Integer;
public class NumMatrix {
    public static void main(String[] args) {
        //输入一个二维矩阵
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> matrix = new ArrayList<>();
        System.out.println("请输入矩阵的行数和列数：");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println("请输入矩阵的元素：");
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }
        int[][] arrays = matrix.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        System.out.println("输入的矩阵为：");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("请输入查询的左上角和右下角坐标：");
        int row1 = scanner.nextInt();
        int col1 = scanner.nextInt();
        int row2 = scanner.nextInt();
        int col2 = scanner.nextInt();
        System.out.println("矩阵和为：" + numMatrix(arrays, row1, col1, row2, col2));
    }
    public static int numMatrix(int[][] matrix, int row1, int col1, int row2, int col2) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int [][] sums=new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum=0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum+=matrix[i][j];
                sums[i+1][j+1]=sums[i][j+1]+rowSum;
            }
        }
        return sums[row2+1][col2+1]-sums[row1][col2+1]-sums[row2+1][col1]+sums[row1][col1];
    }

}
