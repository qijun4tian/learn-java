package 深度搜索;

import java.util.*;

public class AliceWord {

    private  boolean hasCircle =false;

    private Map<Character,String> tempMap = new HashMap<>();


    private  Set<Character> head = new HashSet<>();

    public  String alienOrder(String[] words) {
        boolean[][] tu = new boolean[26][26];
        Set<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        if(words.length == 1){
            return words[0];
        }
        for(int i =0; i< words.length -1; i++){
            if(!compareSrings(words[i],words[i+1],tu,set)){
                return "";
            }
        }

        if(head.size() == 0){
            for (Character character : set) {
                result.append(String.valueOf(character));
            }
            return result.toString();
        }
        if(set.size() == 1){
            for (Character character : set) {
                result = new StringBuilder(String.valueOf(character));
            }
            return result.toString();
        }

        for (Character character : head) {
            dfs(tu,"",character - 'a');
        }
        for (int i = 0; i < tu.length; i++) {
            boolean[] booleans = tu[i];
            for (int j = 0; j < booleans.length; j++) {
                if(booleans[j]){
                    head.remove((char)(j + 'a'));
                }
            }
        }
        if(!hasCircle ){
            List<String> resultList = new ArrayList<>();
            int maxLength = 0;
            for (Map.Entry<Character, String> entry : tempMap.entrySet()) {
                if(head.contains(entry.getKey())) {
                    maxLength = Math.max(maxLength,entry.getValue().length());
                    resultList.add(new StringBuilder(entry.getValue()).reverse().toString());
                }
            }
            int i = 0;
            Set<Character> tempSet = new HashSet<>();
            while (i < maxLength){
                for (int i1 = 0; i1 < resultList.size(); i1++) {
                    if(i < resultList.get(i1).length()) {
                        if(!tempSet.contains(resultList.get(i1).charAt(i))) {
                            tempSet.add(resultList.get(i1).charAt(i));
                            result.append(resultList.get(i1).charAt(i));
                        }
                    }
                }
                i++;
            }
            result.reverse();

            if(result.length() < set.size()) {
                for (Character character : set) {
                    if (!result.toString().contains(String.valueOf(character))){
                        result.append(character);
                    }
                }
            }
            return result.toString();
        }
        return "";
    }

    private  void dfs(boolean[][]tu, String s, int  a){

        boolean[] booleans = tu[a];
        if(hasCircle){
            return;
        }
        if(s.contains(String.valueOf((char)(a + 'a')))){
            System.out.println(s);
            hasCircle = true;
            return;
        }
        String temp = s + (char)(a + 'a');
        String existed = tempMap.get(temp.charAt(0));
        if(existed == null || existed.length() < temp.length()){
            tempMap.put(temp.charAt(0),temp);
        }
        for (int i = 0; i < booleans.length; i++) {
            if(booleans[i]){
                dfs(tu,temp,i);
            }
        }


    }


    public  boolean compareSrings(String a, String b, boolean[][] tu,Set<Character> set){
        int i = 0;
        int j = 0;
        boolean hasOrder = false;
        while (i < a.length() || j < b.length()){
            if(i < a.length() && j < b.length()){
                if(a.charAt(i) != b.charAt(j)){
                    if(!hasOrder) {
                        head.add(a.charAt(i));
                        tu[a.charAt(i) - 'a'][b.charAt(j) - 'a'] = true;
                        hasOrder = true;
                    }
                    set.add(a.charAt(i));
                    set.add(b.charAt(j));
                }else {
                    set.add(a.charAt(i));
                }

            }else if(i < a.length()){
                set.add(a.charAt(i));
            }else {
                set.add(b.charAt(j));
            }

            i++;j++;
        }
        if(!hasOrder && a.length() > b.length()){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        AliceWord aliceWord = new AliceWord();

        String[] words = {"wnlb"};
        System.out.println(aliceWord.alienOrder(words));

    }

}
