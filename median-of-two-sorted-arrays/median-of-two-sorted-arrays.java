class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length; i++){
            list.add(nums1[i]);   
        }
        for(int i=0;i<nums2.length; i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        int n = list.size();
        int mid = (n-1)/2;
        if(n%2 == 0){
            return (double)(list.get(mid)+list.get(mid+1))/2;
        }
        return (double)list.get(mid);
        
        
    }
}

/*
{1,2,3}   3-1/2 = 1
{1,2,3,4}   4-1/2 = 1
{1,2,3,4,5}  5-1/2 = 2
{1,2,3,4,5,6}  6-1/2 2

*/