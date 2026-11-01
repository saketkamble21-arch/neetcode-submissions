class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();

		Arrays.sort(nums);
		if (nums.length == 0 || nums == null) {
			return list;
		}

		for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
			    continue; // Skip this iteration if it's the same as the previous number
			}

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
				} else if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				}
			}
		}
        return list;
    }
}
