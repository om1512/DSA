import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class CharFrequency implements Comparable<CharFrequency>{
    char key;
    int value;
    CharFrequency(char key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(CharFrequency c){
        return c.value - this.value;
    }
}

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<CharFrequency> list = new ArrayList<>();
        for(char c : map.keySet()){
            list.add(new CharFrequency(c, map.get(c)));
        }
        Collections.sort(list);
        String result = "";
        for(CharFrequency cf : list){
            int f = cf.value;
            while(f-- > 0){
                result += cf.key;
            }
        }

        return result;
    }
}