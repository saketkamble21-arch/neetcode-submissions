class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n=nums.length;
        Deque<Integer> deque = new ArrayDeque();
        int res[] = new int[n-k+1];

        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        res[0]=nums[deque.peekFirst()];

        for(int i=k;i<n;i++){

            ////remove the element that slides out
            if(deque.peekFirst()<=i-k){
                deque.pollFirst();
            }

            //remove the peek if less then incoming element
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }

            //add element
            deque.offerLast(i);


            res[i-k+1] = nums[deque.peekFirst()];

        }

        return res;
    }
}
