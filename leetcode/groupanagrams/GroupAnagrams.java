package leetcode.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> solution(String[] strs) {

        List<List<String>> answer = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0; i<strs.length;i++){
            char[] charArrray = strs[i].toCharArray();
            Arrays.sort(charArrray);
            String orderedWord = String.valueOf(charArrray);
            if(map.containsKey((orderedWord))){
                List<String> list = map.get(orderedWord);
                list.add(strs[i]);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(orderedWord,newList);
            }
        }

        for(List<String> answers : map.values()){
            answer.add(answers);
        }

        return answer;
    }

}
