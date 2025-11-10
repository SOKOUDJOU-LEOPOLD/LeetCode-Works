// import java.util.HashMap;
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counts = new int[26]; // For 26 lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++; // Increase for s
            counts[t.charAt(i) - 'a']--; // Decrease for t
        }

        for (int count : counts) {
            if (count != 0) return false;
        }

        return true;
    }
}

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         HashMap<Character, Integer> ht_s = new HashMap<>();
//         HashMap<Character, Integer> ht_t = new HashMap<>();
//         // traversing string S
//         for(int i=0; i < s.length(); i++){
//             ht_s.put(s.charAt(i), ht_s.getOrDefault(s.charAt(i),0)+1);
//         }

//         //traversing string T
//         for(char ch:t.toCharArray()){
//             ht_t.put(ch, ht_t.getOrDefault(ch,0)+1);
//         }


//         //Comparing the hash tables of both S and T
//         if(ht_t.size() != ht_s.size()){
//             return false;
//         }

//         for(char key:ht_t.keySet()){
//             if(!(ht_t.get(key).equals(ht_s.get(key)))){
//                 return false;
//             }
//         }

//         return true;

//     }
// }

