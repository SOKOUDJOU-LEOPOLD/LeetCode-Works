class Solution1 {
    public int maxProfit(int[] prices) { 
        int n = prices.length;
        int[] min_arr = new int[n];
        int[] max_arr = new int[n];

        //filling min_arr
        int min = prices[0];
        min_arr[0] = min;
        // System.out.println(min_arr[0]);
        for(int i=1; i<n; i++){
            min_arr[i] = Math.min(min_arr[i-1], prices[i]);
            System.out.println(min_arr[i]);
        }
        
        // System.out.println("----------");

        int max = prices[n-1];
        max_arr[n-1] = max;
        System.out.println(max_arr[0]);
        for(int i=n-2; i>-1; i--){
            max_arr[i] = Math.max(min_arr[i+1], prices[i]);
            // System.out.println(max_arr[i]);
        }

        int result = 0;
        for(int i=0; i<n; i++){
            result = Math.max(result, max_arr[i]-min_arr[i]);
        }

        return result;

    }   
}



class Solution {
    public int maxProfit(int[] prices) { 
        int min_p = prices[0];
        int n = prices.length;
        int max_profit = 0;
        for(int i=1; i<n;i++){
            if (min_p >= prices[i]){
                min_p = prices[i];
            }else{
                max_profit = Math.max(max_profit, prices[i]-min_p);
            }
        }

        return max_profit;

    }
    
    
}

/*
prices = [7,1,5,3,6,4]
1st method:
min_arr =[7,1,1,1,1,1]
max_arr =[7,6,6,6,6,4]


*/