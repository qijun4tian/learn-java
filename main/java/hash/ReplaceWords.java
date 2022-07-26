package hash;

import java.util.*;

/**
 * @author qijun
 * @date 2022/7/7 19:02
 */
public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        TreeSet<String> treeSet = new TreeSet<String>((a1,a2)->{
            if(a1.length() == a2.length()){
                return a1.compareTo(a2);
            }else {
                return a1.length() - a2.length();
            }

        });
        treeSet.addAll(dictionary);
        String[] stringArray = sentence.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            String temp = stringArray[i];
            for (String s : treeSet) {
                if(temp.startsWith(s)){
                    temp = s;
                    break;
                }
            }
            if(i != stringArray.length -1 ){
                stringBuilder.append(temp).append(" ");
            }else {
                stringBuilder.append(temp);
            }

        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        System.out.println(replaceWords.replaceWords(Arrays.asList("cat","bat","rat"),"the cattle was rattled by the battery"));






    }
}
