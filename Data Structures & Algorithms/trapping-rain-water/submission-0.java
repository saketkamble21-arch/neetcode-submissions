class Solution {
    public int trap(int[] h) {

   int N = h.length;
		int left = 0;
		int right = N - 1;
		int leftMax = h[left], rightMax = h[right];
		int water = 0;

		while (left < right) {

			if (leftMax < rightMax) {
				left++;
				leftMax = Math.max(leftMax, h[left]); // 2
				water=water+leftMax-h[left]; //3
			}else {
				right--; //pointing to : 3
				rightMax = Math.max(rightMax, h[right]); //3
				water=water+rightMax-h[right]; //
			}

		}
        return water;
}
}