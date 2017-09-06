package yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 * Created by ritesh on 8/26/17.
 */
public class MergeIntervals {

    public static void main(String args[]) {

        List<Interval> intervals = new ArrayList<>();

        final Interval interval1 = new Interval(6,9);
        final Interval interval2 = new Interval(10,12);
        final Interval interval3 = new Interval(8,10);
        final Interval interval4 = new Interval(1,2);

        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        final List<Interval> mergedIntervals = merge(intervals);

        for(Interval intrv: mergedIntervals) {
            System.out.println(intrv.start + "," + intrv.end);
        }
    }

    private static List<Interval> merge(List<Interval> intervals) {

        if(intervals==null || intervals.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.valueOf(o1.start).compareTo(Integer.valueOf(o2.start));
            }
        });

        for(int i=0; i<intervals.size();i++) {

            if(i+1 >= intervals.size()) {
                break;
            }

            if(intervals.get(i).end >= intervals.get(i+1).start) {

                merge(intervals,i,i+1);
                i = i-1;
            }
        }

        return intervals;
    }

    private static void merge(List<Interval> intervals, int i, int j) {

        Interval intrv1 = intervals.get(i);
        Interval intrv2 = intervals.get(j);

        Interval newInterval = null;
        if(intrv1.end > intrv2.end) {
            newInterval = new Interval(intrv1.start, intrv1.end);
        }else {
            newInterval = new Interval(intrv1.start, intrv2.end);
        }

        intervals.add(i,newInterval);
        intervals.remove(j);
        intervals.remove(j);
    }

    private static class Interval {
     int start;
     int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
   }
}
