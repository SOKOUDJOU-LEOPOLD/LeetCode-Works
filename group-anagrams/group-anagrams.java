import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Use a hashmap to group by sorted string
        HashMap<String, List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i=0; i<n; i++){
            // convert string to char array
            char[] charr = strs[i].toCharArray();
            // sort char array
            Arrays.sort(charr);
            // convert char array to string
            String key = new String(charr);
            // check if string in map
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        
        return new ArrayList<>(map.values());
    }
}
