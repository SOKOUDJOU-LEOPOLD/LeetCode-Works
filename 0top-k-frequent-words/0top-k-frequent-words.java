
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        // Count the frequency of each word
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Min-Heap with custom comparator
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b.compareTo(a); // reverse lexicographical for same freq
            }
            return freq.get(a) - freq.get(b); // lowest freq first
        });

        // Keep only the top k elements in the heap
        for (String word : freq.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Build result (heap gives smallest first, so reverse it)
        LinkedList<String> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            result.addFirst(heap.poll());
        }

        return result;
    }
}
