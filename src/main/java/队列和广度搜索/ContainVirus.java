package 队列和广度搜索;//package 队列和广度搜索;
//
//import javax.imageio.spi.IIOServiceProvider;
//import java.util.*;
//
///**
// * @author qijun
// * @date 2022/7/19 8:41
// */
//public class ContainVirus {
//
//    public int containVirus(int[][] isInfected) {
//        int m = isInfected.length;
//        int n = isInfected[0].length;
//        boolean[][] visited = new boolean[m][n];
//        for(int i =0; i< m; i++){
//            for(int j =0; j <n ;j++){
//                if(isInfected[i][j] == 1
//                    && !visited[i][j]){
//                    bfs(isInfected,i,j,visited);
//
//                }
//
//            }
//        }
//    }
//
//
//
//    List<int[]>bfs(int[][] isInfected, int i, int j, boolean[][] visited){
//        List<int[]> result = new ArrayList<>();
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{i,j});
//        while (queue.size() !=0 ){
//            int size = queue.size();
//            for(int k =0; k<size; k++){
//                int[] poll = queue.poll();
//                int tempi = poll[0];
//                int tempj =
//                if(isInfected[poll[0]][poll[1]] == 1){
//                    visited[poll[0]][poll[1]] = true;
//
//
//            }
//
//
//        }
//
//
//    }
//}
