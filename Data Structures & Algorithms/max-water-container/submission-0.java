class Solution {
    public int maxArea(int[] heights) {
        
        int N= heights.length;

        int left = 0;
        int right = N-1;
        int maxCap =0;

        while(left < right){
            int width = right -left;
            int height = Math.min(heights[left],heights[right]);
            int currentCap = width*height;

            maxCap = Math.max(maxCap,currentCap);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxCap;
    }
}
