class Solution {
    public int findMin(int[] nums) {
        
        int l =0;
        int r = nums.length-1;
        if(nums[l]<= nums[r]){
            return nums[l];
        }

        while(l<=r){
            
            int m = l+(r-l)/2;

            if(m<r && nums[m] > nums[m+1] ){
                return nums[m+1];
            }else if(nums[m-1]>nums[m] && l<m){
                return nums[m];
            }
            if(nums[l]<=nums[m]){
                l = m+1;
            }else{
                r = m-1;
            }
        }

        return nums[0];
    }
}
