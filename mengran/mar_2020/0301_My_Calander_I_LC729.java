//Implement a MyCalendar class to store your events. A new event can be added if
// adding the event will not cause a double booking.
//
// Your class will have the method, book(int start, int end). Formally, this rep
//resents a booking on the half open interval [start, end), the range of real numb
//ers x such that start <= x < end.
//
// A double booking happens when two events have some non-empty intersection (ie
//., there is some time that is common to both events.)
//
// For each call to the method MyCalendar.book, return true if the event can be
//added to the calendar successfully without causing a double booking. Otherwise,
//return false and do not add the event to the calendar.
//Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCale
//ndar.book(start, end)
//
// Example 1:
//
//
//MyCalendar();
//MyCalendar.book(10, 20); // returns true
//MyCalendar.book(15, 25); // returns false
//MyCalendar.book(20, 30); // returns true
//Explanation:
//The first event can be booked.  The second can't because time 15 is already bo
//oked by another event.
//The third event can be booked, as the first event takes every time less than 2
//0, but not including 20.
//
//
//
//
// Note:
//
//
// The number of calls to MyCalendar.book per test case will be at most 1000.
// In calls to MyCalendar.book(start, end), start and end are integers in the ra
//nge [0, 10^9].
//
//
//
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class MyCalendar {
TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer floorKey = map.floorKey(start);
        if(floorKey != null && map.get(floorKey) > start) return false;
        Integer ceilingKey = map.ceilingKey(start);
        if(ceilingKey != null && ceilingKey < end) return false;
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

 /**
Problem: https://leetcode.com/problems/my-calendar-i/
Analysis:
use treeMap to solve this problem
floorKey() the most largest key which is less or equals to the target
ceilingKey() the most smallest key which is greater or equals to the target
Time Complexity: Log(N)
Space Complexity: O(N)
tag: #TreeMap
 **/
