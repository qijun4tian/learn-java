package java.深度搜索;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class 岛屿的最大面积 {

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int resut = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    resut = Math.max(resut,dfs(i,j,grid,visited));
                }
            }
        }
        return resut;


    }

    public static int dfs(int i, int j, int[][]grid, boolean[][] visited){
        Deque<int[]> deque = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        deque.add(new int[]{i,j});
        visited[i][j] = true;
        int count = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i1 = 0; i1 < size; i1++) {

                int[] poll = deque.poll();
                int tempI = poll[0];
                int tempJ = poll[1];
                count++;
                if(tempI -1 >= 0 && !visited[tempI-1][tempJ] && grid[tempI- 1][tempJ] == 1){
                    visited[tempI-1][tempJ] = true;
                    deque.add(new int[]{tempI-1,tempJ});
                }
                if(tempI + 1 < m && !visited[tempI+1][tempJ]  && grid[tempI +  1][tempJ] == 1){
                    visited[tempI + 1][tempJ] = true;
                    deque.add(new int[]{tempI + 1,tempJ});
                }
                if(tempJ- 1 >= 0 && !visited[tempI][tempJ-1] && grid[tempI][tempJ -1] == 1){
                    visited[tempI][tempJ -1] = true;
                    deque.add(new int[]{tempI,tempJ-1});
                }
                if(tempJ + 1 < n && !visited[tempI][tempJ+1] && grid[tempI][tempJ + 1] == 1){
                    visited[tempI][tempJ + 1] = true;
                    deque.add(new int[]{tempI,tempJ+1});
                }

            }
        }

        return count;

    }

    public static void main(String[] args) {

        int a[][] = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(a));
    }
}
