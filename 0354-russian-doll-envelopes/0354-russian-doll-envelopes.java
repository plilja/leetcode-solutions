class Solution {
    public int maxEnvelopes(int[][] envelopesArr) {
        List<Envelope> envelopes = new ArrayList<>();
        for (int[] envelope : envelopesArr) {
            int w = envelope[0];
            int h = envelope[1];
            envelopes.add(new Envelope(w, h));
        }
        Collections.sort(envelopes, (a, b) -> {
            if (a.width() != b.width()) {
                return a.width() - b.width();
            } else {
                return b.height() - a.height();
            }
        });
        TreeMap<Integer, Integer> heightToSize = new TreeMap<>();
        TreeMap<Integer, Integer> sizeToHeight = new TreeMap<>();
        for (int i = 0; i < envelopes.size(); ++i) {
            var envelope = envelopes.get(i);
            var entry = heightToSize.floorEntry(envelope.height() - 1);
            int size = 1;
            if (entry != null) {
                size = entry.getValue() + 1;
            } 
            Integer oldValue = sizeToHeight.get(size);
            if (oldValue == null || oldValue > envelope.height()) {
                sizeToHeight.put(size, envelope.height());
                heightToSize.put(envelope.height(), size);
                if (oldValue != null) {
                    heightToSize.remove(oldValue);
                }
            }
        }
        return sizeToHeight.lastKey();
    }
    
    private record Envelope(int width, int height) {
    }
}