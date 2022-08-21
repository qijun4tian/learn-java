package 栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<String[]> deque = new LinkedList();
        int lastEnd = 0;
        for(String s : logs){
            String[] tempArray = s.split(":");
            if(deque.size() == 0){
                deque.add(tempArray);
            }else {
                if(tempArray[1].equals("end")){
                    String [] in = deque.pop();
                    int begin = Integer.parseInt(in[2]);
                    if(begin < lastEnd){
                        begin = lastEnd;
                    }
                    int size = Integer.parseInt(tempArray[2]) - begin +1;
                    result[Integer.parseInt(in[0])] += size;
                    lastEnd = Integer.parseInt(tempArray[2]) +1 ;
                }else {
                    String[] in = deque.pop();
                    int begin = Integer.parseInt(in[2]);
                    if(begin < lastEnd){
                        begin = lastEnd;
                    }
                    int size = Integer.parseInt(tempArray[2])- begin;
                    result[Integer.parseInt(in[0])] += size;
                    in[2] = tempArray[2];
                    deque.push(in);
                    deque.push(tempArray);


                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ExclusiveTime exclusiveTime = new ExclusiveTime();
        int[] a = exclusiveTime.exclusiveTime(1, Arrays.asList(
                "0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));


    }
}
