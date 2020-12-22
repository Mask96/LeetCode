package com.company;

/**
 * @description:
 * @author: Mask
 * @time: 2020/12/22 5:28 下午
 */
public class Xuanzhuanjuxing {

    //此方法用于对二维数组进行水平翻转操作。
    public int[][] change(int[][] matrix) {
        //rows 用来保存二维数组的行数最大值
        int tem = 0, row_max = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //（row_max - i）为倒数i行对应的行。
                tem = matrix[row_max - i][j];
                matrix[row_max - i][j] = matrix[i][j];
                matrix[i][j] = tem;
            }
        }
        return matrix;
    }

    // 垂直翻转
    public int[][] change2(int[][] matrix) {
        int tem = 0, row_max = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                tem = matrix[i][row_max - j];
                matrix[i][row_max - j] = matrix[i][j];
                matrix[i][j] = tem;
            }
        }
        return matrix;
    }

    // 主对角线反转
    public int[][] change3(int[][] matrix) {
        int tem;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                tem = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tem;
            }
        }
        return matrix;
    }

    // 次对脚线
    public int[][] change4(int[][] matrix) {
        int len = matrix.length, term = 0;
        for (int i = 0; i < len - 1; i++) {
            //(len-1)为矩形数组的最大下标值    //j+i<len-1为限定只交换数组对角线上方的元素
            for (int j = 0, n = len - 1 - i; j < len - 1 - i; j++, n--) {
                // n=len-1-i => n+i=len-1
                // j<len-1-i <=> j+i<len-1
                // n与i的和为矩形数组下标最大值,j与i的和不大于矩形数组下标的最大值
                term = matrix[i][j];
                matrix[i][j] = matrix[i + n][j + n];
                matrix[i + n][j + n] = term;
            }
        }
        return matrix;
    }
}
