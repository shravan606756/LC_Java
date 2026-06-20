import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {

            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}