class Solution {
    public int characterReplacement(String s, int k) {
        
        int count[] = new int[26];
        int left =0;
        int maxFreq = 0;
        int maxLen = 0;
        int n=s.length();
        for(int right=0;right<n;right++){

            char c = s.charAt(right);
            count[c-'A']++;

            maxFreq = Math.max(maxFreq,count[c-'A']);
            int windowLength = right-left+1;

            if(windowLength - maxFreq > k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            windowLength =  right-left+1;
            maxLen = Math.max(maxLen,windowLength);
        }

        return maxLen;


    }
}
