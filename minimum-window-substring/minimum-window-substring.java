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
            if(map.containsKey(ch) && win.get(ch).intValue() == map.get(ch).intValue()){
                counter ++;
            }
                
            while(counter == required){
                // check if we have new minimum values
                System.out.println("ddddddddddd");
                if(minLen> right-left+1){
                    minLen = right-left+1;
                    startIndex = left;
                } 
                    
                char cha = s.charAt(left);
                win.put(cha, win.get(cha)-1);
                if(map.containsKey(cha) && win.get(cha).intValue()<map.get(cha).intValue()){
                    counter --;
                }
                left++;                        
            }
            
            right++;
        }
        
        if(minLen == Integer.MAX_VALUE){
            System.out.println("dsd");
            return "";
        }
        return s.substring(startIndex, startIndex+minLen);
    }
}