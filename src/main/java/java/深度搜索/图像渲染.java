package java.深度搜索;

import java.util.Deque;
import java.util.LinkedList;

public class 图像渲染 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{sr,sc});
        int originValue = image[sr][sc];
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] pop = deque.pop();
                int tempM = pop[0];
                int tempN = pop[1];
                visited[tempM][tempN] = true;
                image[tempM][tempN] = newColor;

                if(tempM -1 >=0 && !visited[tempM -1][tempN] && originValue == image[tempM-1][tempN]){
                    deque.add(new int[]{tempM-1,tempN});
                }
                if(tempM + 1 < m && !visited[tempM + 1][tempN] && originValue == image[tempM + 1][tempN]){
                    deque.add(new int[]{tempM + 1,tempN});
                }
                if(tempN -1 >=0 && !visited[tempM][tempN -1] && originValue == image[tempM][tempN - 1]){
                    deque.add(new int[]{tempM,tempN - 1});
                }
                if(tempN + 1 < n && !visited[tempM][tempN + 1] && originValue == image[tempM][tempN + 1]){
                    deque.add(new int[]{tempM,tempN + 1});
                }

            }

        }
        return image;

    }
}
