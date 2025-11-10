class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();
        for(int i=1; i<n+1;i++){
            if(i%3 != 0 && i%5 != 0){res.add(""+i);}
            else if(i%3 == 0 && i%5 == 0){res.add("FizzBuzz");}
            else if(i%3 == 0){res.add("Fizz");}
            else{res.add("Buzz");}
            
        }
        return res;
        
    }
}