class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
		
		HashMap<Integer,Integer> map = new HashMap<>();

		for(int i: nums) {

			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				map.put(i, 1);
			}
		}

		Comparator<int[]> c = (a,b)-> Integer.compare(b[1],a[1]);
		PriorityQueue<int[]> queue = new PriorityQueue(c);
		
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		for (Map.Entry<Integer, Integer> s : set) {
			queue.offer(new int[] { s.getKey(), s.getValue() });
		}
		
		int[] result = new int[k];
		while (k > 0) {
			int[] poll = queue.poll();
			result[k-1] = poll[0];
			k--;
		}
		
        return result;
        
    }
}
