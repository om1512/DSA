import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> h = new HashMap<>();
        StringBuffer ans =new StringBuffer();
        char[] c = s.toCharArray();
        for(char i:c){
        h.put(i,h.getOrDefault(i, 0)+1);
        }
        List<Entry<Character,Integer>> l = new ArrayList<>(h.entrySet());
        Collections.sort(l,new Comparator<Entry<Character,Integer>>() {
        @Override
        public int compare(Entry<Character,Integer> o1,Entry<Character,Integer>o2){
            return o2.getValue().compareTo(o1.getValue());
        }
        });
        l.forEach(str -> {
            for(int i=0;i<str.getValue();i++){
                ans.append(str.getKey());
            }         
        });
        return ans.toString();
    }
}