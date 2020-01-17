package heap;

import java.util.*;

public class TopKFrequentWords {
    
    static class Pair implements Comparable<Pair>{
        String val;
        int count;

        Pair(String val, int count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Pair another) {
            if (this.count == another.count) {
                return 0;
            }

            return this.count < another.count ? -1 : 1;
        }
        
    }

    // Find a list of the top K most frequent words in the composition. 
    public String[] topKFrequent(String[] combo, int k) {
        Queue<Pair> minHeap = new PriorityQueue<>(k);
        Map<String, Integer> strCounter = new HashMap<>();

        // get frequency of each string
        for (String str : combo) {
            if (strCounter.containsKey(str)) {
                strCounter.put(str, strCounter.get(str) + 1);
            } else {
                strCounter.put(str, 1);
            }
        }

        // scan through the map and update the heap
        for (Map.Entry<String, Integer> entry : strCounter.entrySet()) {
            Pair newPair = new Pair(entry.getKey(), entry.getValue());
            if (minHeap.size() < k) {
                minHeap.offer(newPair);
            } else if (newPair.count > minHeap.peek().count) {
                minHeap.poll();
                minHeap.offer(newPair);
            }
        }

        // get the result from the heap
        // cannot use k because the actual number of results may be less than k
        String[] res = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; --i) {     
            res[i] = minHeap.poll().val;
        }

        return res;
    }

    public static void main(String[] args)
	{
        String[] arr = new String[]{"d","a","c","b","d","a","b","b","a","d","d","a","d"};

        TopKFrequentWords solution = new TopKFrequentWords();
        String[] newArr = solution.topKFrequent(arr, 5);
        System.out.println(Arrays.toString(newArr));
    }

}