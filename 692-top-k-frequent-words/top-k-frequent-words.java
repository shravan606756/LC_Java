class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Queue<Pair> heap = new PriorityQueue<>((a, b) -> {
            if (a.frequency == b.frequency) {
                return b.word.compareTo(a.word); 
            } else {
                return a.frequency - b.frequency;
            }
        });

        Map<String, Integer> map = new HashMap<>();

        for (String x : words) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String key = entry.getKey();
            int value = entry.getValue();

            Pair curr = new Pair(value, key);

            if (heap.size() < k) {
                heap.offer(curr);
            } else {

                Pair top = heap.peek();

                if (curr.frequency < top.frequency ||
                   (curr.frequency == top.frequency &&
                    curr.word.compareTo(top.word) > 0)) {
                    continue;
                }

                heap.poll();
                heap.offer(curr);
            }
        }

        List<String> res = new ArrayList<>();

        while (!heap.isEmpty()) {
            res.add(heap.poll().word);
        }

        Collections.reverse(res);

        return res;
    }
}

class Pair {
    int frequency;
    String word;

    Pair(int frequency, String word) {
        this.frequency = frequency;
        this.word = word;
    }
}