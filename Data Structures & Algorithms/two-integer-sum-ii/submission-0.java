class Solution {
    public int[] twoSum(int[] a, int target) {
    
        HashMap map = new HashMap<>();
		
		for(int i=0;i<a.length;i++) {
			
			int diff=target-a[i];
			if(map.containsKey(diff)) {
				return new int[] {(int) map.get(diff)+1,i+1};
			}
			map.put(a[i], i);
		}
		
		return new int[] {};
        
        
    }
}
