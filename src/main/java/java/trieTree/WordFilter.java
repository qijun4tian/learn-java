package java.trieTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author qijun
 * @date 2022/7/14 19:28
 */
public class WordFilter {
    TrieNode root = new TrieNode();
    String[] words = null;

    public WordFilter(String[] words) {
        int index = 0;
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                insert(word.substring(i), index);

            }
            index++;

        }
        this.words = words;


    }

    public void insert(String s, int index) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); ++i) {
            int u = s.charAt(i) - 'a';
            if(p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.end = true;
        if(p.list == null){
            p.list = new ArrayList();
        }
        p.list.add(index);
    }

    public int f(String pref, String suff) {
        List<Integer> list2 = searchPref(suff);
        if(list2 == null){
            return -1;
        }
        list2.sort(Comparator.comparing(Integer::intValue).reversed());
        for (Integer i : list2) {
            if(words[i].startsWith(pref)){
                return i;
            }
        }
        return -1;

    }

    public List<Integer> searchPref(String pref){
        TrieNode p = root;
        for(int i =0; i< pref.length(); i++){
            int a = pref.charAt(i) - 'a';
            if(p.tns[a] == null){
                return null;
            }
            p = p.tns[a];

        }
        if(p.end){
            return p.list;

        }else{
            return null;
        }

    }

    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
        List<Integer> list = null;
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"abbba","abba"});

        System.out.println(wordFilter.f("ab", "ba"));
    }
}
