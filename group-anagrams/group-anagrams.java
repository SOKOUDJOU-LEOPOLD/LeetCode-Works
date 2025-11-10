import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Use a hashmap to group by sorted string
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to character array and sort
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add to the hashmap
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        // Return the grouped anagrams
        // return new ArrayList<>(map.values());
        return new ArrayList<>(map.values());
    }
}
