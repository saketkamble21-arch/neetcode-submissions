class Solution {
    public int findMin(int[] nums) {
        
        int rot=0;
        for(int i=0,j=1;i<nums.length;i++,j++){

            if(j==nums.length){
                rot=nums[0];
                break;
            }else
            if(nums[i]<nums[j]){
                continue;
            }else if(nums[i]>nums[j]){
                rot = nums[j];
                break;
            } 
            
        }

        return rot;

    }
}
