class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return List.of();
        } else {
            ArrayList<Long> result = new ArrayList<>();
            long nextEvenNumber = 2;
            long sum = 0;
            while (sum + nextEvenNumber < finalSum) {
                result.add(nextEvenNumber);
                sum += nextEvenNumber;
                nextEvenNumber += 2;
            }
            long diff = sum + nextEvenNumber - finalSum;
            if (diff == 0) {
                result.add(nextEvenNumber);
            } else {
                for (int i = 0; i < result.size(); ++i) {
                    if (result.get(i) == diff) {
                        result.set(i, nextEvenNumber);
                        break;
                    }
                }
            }
            return result;
        }
    }
}
