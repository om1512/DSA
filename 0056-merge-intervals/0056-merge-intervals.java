class task implements Comparable<task>{
  int start;
  int end;
  task(int start,int end){
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(task o) {
    return this.start-o.start;
  }
}
class Solution {
    public int[][] merge(int[][] intervals) {
    
    List<task> l = new ArrayList<>();
    for(int[] a:intervals){
      l.add(new task(a[0],a[1]));
    }
    Map<Integer,Integer> m = new LinkedHashMap<>();
    Collections.sort(l);
    int preEnd = Integer.MIN_VALUE;
    int  preStart = 0;
     for(task t : l){
      if(t.start > preEnd){
        m.put(t.start,t.end);
        preStart = t.start;
        preEnd = t.end;
      }else{
        if(preEnd<t.end){
          m.put(preStart,t.end);
          preEnd = t.end;
        }else{
          m.put(preStart,preEnd);
        }
      }
     
      
    }
        int[][] ans = new int[m.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> e:m.entrySet()){
        ans[index][0] = e.getKey();
        ans[index][1] = e.getValue();
        index++;
        }
        return ans;
    }

}