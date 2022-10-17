import java.util.*;

class SnapshotArray {
    private int currentSnapshot = 0;
    private final ArrayList<TreeMap<Integer, Integer>> values;

    public SnapshotArray(int length) {
        values = new ArrayList<>(length);
        for (int i = 0; i < length; ++i) {
            var indexValues = new TreeMap<Integer, Integer>();
            indexValues.put(currentSnapshot, 0);
            values.add(indexValues);
            
        }
    }
    
    public void set(int index, int val) {
        var indexValues = values.get(index);
        indexValues.put(currentSnapshot, val);
    }
    
    public int snap() {
        return currentSnapshot++;
    }
    
    public int get(int index, int snap_id) {
        var indexValues = values.get(index);
        return indexValues.floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
