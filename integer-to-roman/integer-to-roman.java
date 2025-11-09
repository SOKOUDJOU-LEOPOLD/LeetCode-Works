class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        int n= num;
        String res = "";
        while(n != 0){
            if(n>=1000){
                n = n-1000;
                res += map.get(1000);
            }else if(n>=900){
                n = n-900;
                res += map.get(900);
            }else if(n>=500){
                n = n-500;
                res += map.get(500);
            }else if(n>=400){
                n = n-400;
                res += map.get(400);
            }else if(n>=100){
                n = n-100;
                res += map.get(100);
            }else if(n>=90){
                n = n-90;
                res += map.get(90);
            }else if(n>=50){
                n = n-50;
                res += map.get(50);
            }else if(n>=40){
                n = n-40;
                res += map.get(40);
            }else if(n>=10){
                n = n-10;
                res += map.get(10);
            }else if(n>=9){
                n = n-9;
                res += map.get(9);
            }else if(n>=5){
                n = n-5;
                res += map.get(5);
            }else if(n>=4){
                n = n-4;
                res += map.get(4);
            }else if(n>=1){
                n = n-1;
                res += map.get(1);
            }else{
                break;
            }
        }
        
        return res;
        
    }
}


/*

I will have a hashmap of these:
I	1
IV  4
V	5
IX   9   <-
X	10
XL   40  <-
L	50
XC   90    <-
C	100
CD  400   <- 
D	500
CM   900    <-
M	1000

-I will initialize  n = num;
-while num != 0:
    - I check which element is just smaller or equal than the cur n.
    - when I find it i put it inside my string I am building.



*/