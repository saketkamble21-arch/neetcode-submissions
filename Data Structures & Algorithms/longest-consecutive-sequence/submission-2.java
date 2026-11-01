class Solution {
    public int longestConsecutive(int[] nums) {

     if(nums.length ==0 || nums ==null){
        return 0;
     }

     Set<Integer> set = new HashSet();
     for(int i: nums){
        set.add(i);
     }

    int count=0;

     for(int s: set){

        if(!set.contains(s-1)){
            int start=s;
            int localstreak=1;

            while(set.contains(start+1)){
                start++;
                localstreak++;
            }
        count= Math.max(count,localstreak);
        }
     }

        return count;
    }
}
