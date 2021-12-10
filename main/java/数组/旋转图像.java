package 数组;

/**
 * @Author:qijun
 * @Description
 * @Date 20:34 2021/12/10
 */
public class 旋转图像 {

    public void rotate(int[][] matrix) {

        /**
         *  00 02
         *  01 12
         *  02 22
         *  10 01
         *  11 11
         *  12 21
         *
         *
         */
        int length = matrix.length;
        int size = matrix[0].length;
        // 上下交换 0和3交换 1和2交换
        for(int i = 0; i< length /2; i++){
            for(int j =0; j < size; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-1-i][j];
                matrix[length-1-i][j] = temp;
            }
        }
        // 对角线交换
        for(int i = 0; i< length; i++){
            for(int j =i+1; j < size; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }




    }
}
