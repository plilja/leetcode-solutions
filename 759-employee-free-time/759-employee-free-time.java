/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedules) {
        List<Interval> busy = schedules.get(0);
        for (int i = 1; i < schedules.size(); ++i) {
            List<Interval> schedule = schedules.get(i);
            int pointer1 = 0;
            int pointer2 = 0;
            List<Interval> busyNew = new ArrayList<>();
            while (pointer1 < busy.size() || pointer2 < schedule.size()) {
                if (pointer1 < busy.size() && !busyNew.isEmpty()) {
                    var lastInterval = busyNew.get(busyNew.size() - 1);
                    var interval = busy.get(pointer1);
                    if (overlaps(lastInterval, interval)) {
                        var newInterval = new Interval(
                            Math.min(interval.start, lastInterval.start),
                            Math.max(interval.end, lastInterval.end)
                        );
                        busyNew.set(busyNew.size() - 1, newInterval);
                        pointer1++;
                        continue;
                    }
                }
                if (pointer2 < schedule.size() && !busyNew.isEmpty()) {
                    var lastInterval = busyNew.get(busyNew.size() - 1);
                    var interval = schedule.get(pointer2);
                    if (overlaps(lastInterval, interval)) {
                        var newInterval = new Interval(
                            Math.min(interval.start, lastInterval.start),
                            Math.max(interval.end, lastInterval.end)
                        );
                        busyNew.set(busyNew.size() - 1, newInterval);
                        pointer2++;
                        continue;
                    }
                }
                if (pointer1 == busy.size()) {
                    busyNew.add(schedule.get(pointer2));
                    pointer2++;
                } else if (pointer2 == schedule.size()) {
                    busyNew.add(busy.get(pointer1));
                    pointer1++;
                } else if (busy.get(pointer1).end < schedule.get(pointer2).end) {
                    busyNew.add(busy.get(pointer1));
                    pointer1++;
                } else {
                    busyNew.add(schedule.get(pointer2));
                    pointer2++;
                }
            }
            busy = busyNew;
        }
        List<Interval> result = new ArrayList<>();
        for (int i = 1; i < busy.size(); ++i) {
            Interval prev = busy.get(i - 1);
            Interval interval = busy.get(i);
            result.add(new Interval(prev.end, interval.start));
        }
        return result;
    }
    
    private boolean overlaps(Interval a, Interval b) {
        if (a.start <= b.start && a.end >= b.start) {
            return true;
        }
        if (b.start <= a.start && b.end >= a.start) {
            return true;
        }
        return false;
    }
}