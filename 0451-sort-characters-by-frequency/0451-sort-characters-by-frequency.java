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
        StringBuffer ans = new StringBuffer();
        char[] c = s.toCharArray();
        for(char i:c){
        h.put(i,h.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Character> q = new PriorityQueue<>((a,b) -> h.get(b)-h.get(a));
        q.addAll(h.keySet());
        while(!q.isEmpty()){
        char ch = q.remove();
            for(int i=0;i<h.get(ch);i++){
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}