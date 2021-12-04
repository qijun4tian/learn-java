package 字符串;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Author:qijun
 * @Description
 * @Date 16:46 2021/12/4
 */
public class 最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        Integer integer = Arrays.stream(strs).map(String::length).min(Integer::compareTo).get();
        int length = 0;
        for(int i = 0 ;i< integer; i++){
            boolean flag = true;
            char c = strs[0].charAt(i);
            for (int i1 = 1; i1 < strs.length; i1++) {
                if(strs[i1].charAt(i) != c){
                    flag = false;
                    break;

                }
            }
            if(!flag){
                break;
            }
            length = i+ 1;
        }
        return strs[0].substring(0,length);

    }
}
