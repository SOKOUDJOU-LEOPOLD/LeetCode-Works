class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        
        int i = 0;
        int res = 0;
        int n = s.length();
        while(i<n){
            if(i+1<n && map.containsKey(s.charAt(i)+""+s.charAt(i+1))){
                res += map.get(s.charAt(i)+""+s.charAt(i+1));
                i = i+2;
            }else{
                res += map.get(s.charAt(i)+"");
                i++;
            }
        }
        
        return res;
    }
}