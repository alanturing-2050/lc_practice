class RangeModule {
    TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap();
    }

    public void addRange(int left, int right) {
        Integer start = map.floorKey(left);
        if(start == null) start = map.ceilingKey(left);
        while(start != null && start <= right) {
            Integer end = map.get(start);
            if(end >= left) {
                map.remove(start);
                if(left > start) left = start;
                if(end > right) right = end;
            }
            start = map.ceilingKey(end);
        }
        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        return start != null && map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = map.floorKey(left);
        if(start == null) start = map.ceilingKey(left);
        while(start != null && start <= right) {
            Integer end = map.get(start);
            if(end >= left) {
                map.remove(start);
                if(left > start) map.put(start, left);
                if(end > right) map.put(right, end);
            }
            start = map.ceilingKey(end);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */


 /**
Problem: https://leetcode.com/problems/range-module/
Analysis:
We can use TreeMap to represent the range
for adding(lef, right);
3 scenarios:
        left        right             left         right               left          right
          |___________|                 |____________|                   |_____________|
      start      end                        start       end         start                   end
        |_________|                           |___________|           |_______________________|
if current range not cover left and right we keep check the next range by calling start = map.ceilingKey(end);
TimeComplexity: O(log(n))
SpaceComplexity: O(n)
tag: #TreeMap
 **/
