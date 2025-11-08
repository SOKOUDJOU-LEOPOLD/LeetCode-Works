class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); 
        if(n == 0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        int len  = 0;
        while(r<n){
            if(set.contains(s.charAt(r))){
                len = Math.max(len, set.size());
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
            }else{
                set.add(s.charAt(r));
                System.out.println(s.charAt(r));
            }
            r++;
        }
        
        len = Math.max(len, set.size());
        
        return len;
        
    }
}

/*
Idea: I will implement a sliding window with set to know the elements in the window


Steps:
-> declare Two pointers l,r to move my window.
-> declare a set to containe elements in the window.
-> declare a var to hold the size of the window
-> l, r start at index 0
-> r will be moving to the right and updating the set until we find a duplicate.
    -> if duplicate found, we move l to the right whil removing corrsponding ele until the 
        duplicate in the set disappear and we add the new occurence of the ele.
    -> else, we add the new element in the set. And after each add, we update the var of the size

-> return the var.


*/