package 字符串;

import javax.xml.stream.FactoryConfigurationError;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:qijun
 * @Description
 * @Date 22:18 2021/11/24
 */
public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        boolean isUnique = false;
        for (int i = 0; i < chars.length; i++) {
            map.compute(chars[i],(key,value)->{
                if(value == null){
                    return 1;
                }else {
                    return value +1;
                }

            });
        }
        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;

    }
}
