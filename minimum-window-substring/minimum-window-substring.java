class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length()==0|| s.length()<t.length()){
            return "";
        }
        
        HashMap<Character, Integer>  map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int required = map.size();
        
        int counter = 0;
        
        HashMap<Character, Integer> win = new HashMap<>();
        
        int left=0, right=0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        
        // moving right
        while(right<s.length()){
            char ch = s.charAt(right);
            win.put(ch, win.getOrDefault(ch, 0)+1);
            // increment counter
            if(map.containsKey(ch) && (int)win.get(ch) == (int)map.get(ch)){
                counter ++;
            }
                
            while(counter == required){
                // check if we have new minimum values
                if(minLen> right-left+1){
                    minLen = right-left+1;
                    startIndex = left;
                } 
                    
                char cha = s.charAt(left);
                win.put(cha, win.get(cha)-1);
                if(map.containsKey(cha) && (int)win.get(cha) < (int)map.get(cha)){
                    counter --;
                }
                left++;                        
            }
            
            right++;
        }
        
        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startIndex, startIndex+minLen);
    }
}