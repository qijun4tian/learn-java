package 数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author:qijun
 * @Description
 * @Date 20:14 2021/11/22
 */
public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        Map<Character,Integer> sets = new HashMap<>();
        Map<Character,Integer> sets1 = new HashMap<>();
        Map<Character,Integer> sets2 = new HashMap<>();
        Map<Character,Integer> sets3 = new HashMap<>();
        Map<Character,Integer> sets4 = new HashMap<>();
        int k = 0;
        for(int i =0;i < 9;i++,k++){
            sets.clear();
            sets1.clear();
            if(k == 3){
                sets2.clear();
                sets3.clear();
                sets4.clear();
                k = 0;
            }
            for(int j = 0; j < 9; j++){
                Character key = board[i][j];
                if(extracted(sets,key)){
                    System.out.println(1);
                    System.out.println(i + " " + j + " " + key );
                    return false;
                }
                if(j<=2){
                    if (extracted(sets2, key)){
                        System.out.println(2);
                        System.out.println(i + " " + j + " " + key );
                        return false;
                    }
                }else if(j > 2 && j <=5 ){
                    if (extracted(sets3, key)){
                        System.out.println(3);
                        System.out.println(i + " " + j + " " + key );
                        return false;
                    }
                }else {
                    if (extracted(sets4, key)){
                        System.out.println(4);
                        System.out.println(i + " " + j + " " + key );
                        return false;
                    }
                }
                key = board[j][i];
                if (extracted(sets1, key)){
                    System.out.println(5);
                    System.out.println(i + " " + j + " " + key );
                    return false;
                }

            }
        }
        return true;
    }

    private boolean extracted(Map<Character, Integer> sets1, Character key) {
        if(key != '.'){
            sets1.compute(key,(k1, value)->{
                if(value == null){
                    return 1;
                }else {
                    return ++value;
                }
            });
            return sets1.get(key) > 1;
        }
        return false;
    }

    /**
     *
     *  作者：莫莫绵
     *     链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/?discussion=1XxGH8
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {
        for(int i = 0;i < 9;i++){
            HashSet setLine = new HashSet();
            HashSet setCol = new HashSet();
            HashSet setBox = new HashSet();
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.' &&!setLine.add(board[i][j])){
                    return false;
                }
                if(board[j][i] != '.' && !setCol.add(board[j][i])){
                    return false;
                }
                int a = (i/3)*3 + j/3;
                int b = (i%3)*3 + j%3;
                if(board[a][b] != '.' && !setBox.add(board[a][b])){
                    return false;
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {
        char[][] a  = { {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};

        //System.out.println(isValidSudoku(a));
    }



}
