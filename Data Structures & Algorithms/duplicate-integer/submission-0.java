class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        HashSet set = new HashSet<>();
		boolean b = false;
		for(int i : nums) {
			
			if (!set.add(i)) {
				b=true;
				break;
			}
		}
		
		return b;
		

        
    }
}