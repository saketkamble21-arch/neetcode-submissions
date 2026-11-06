class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        int l=0;
        int max=0;

        for(int r=0;r<s.length();r++){

            char c = s.charAt(r);

            map.put(c, map.getOrDefault(c, 0)+1);
            
            while(map.get(c)>1){
                char cl = s.charAt(l);
                map.put(cl, map.get(cl)-1);
                l++;
            }

            max= Math.max(max,r-l+1);
        }
        return max;
    }
}
