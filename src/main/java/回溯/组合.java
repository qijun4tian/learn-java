package 回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 组合 {

    public static List<List<Integer>> combine(int n, int k) {
        boolean[] used = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Integer> deque = new LinkedList<>();
        dfs(k,used,n,0,result,deque);
        return result;

    }

    private static void dfs(int k, boolean[] used, int n, int length,List<List<Integer>> result,Deque<Integer> deque){

        if(length == k){
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!used[i]){
                if(!deque.isEmpty() && deque.getLast() > i + 1){
                    continue;
                }
                deque.add(i+1);
                System.out.println("111" + deque);
                used[i] = true;
                dfs(k,used,n,length+1,result,deque);
                int size = deque.size();
                used[i] = false;
                deque.removeLast();
                System.out.println("222" + deque);
            }

        }
    }

//    public static List<List<Integer>> combine(int n, int k) {
//        boolean[] used = new boolean[n];
//        List<List<Integer>> result = new ArrayList<>();
//
//        LinkedList<Integer> deque = new LinkedList<>();
//        dfs(k,used,n,0,result,deque);
//        return result;
//
//    }
//
//    private static void dfs(int k, boolean[] used, int n, int length,List<List<Integer>> result,Deque<Integer> deque){
//
//        if(length == k){
//            result.add(new ArrayList<>(deque));
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if(!used[i]){
//                deque.add(i+1);
//                System.out.println("111" + deque);
//                used[i] = true;
//                dfs(k,used,n,length+1,result,deque);
//                int size = deque.size();
//                used[i] = false;
//                deque.removeLast();
//                System.out.println("222" + deque);
//            }
//
//        }
//    }

    public static void main(String[] args) {
        combine(4,2);
    }




}
