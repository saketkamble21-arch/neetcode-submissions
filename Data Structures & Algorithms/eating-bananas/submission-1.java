class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = 0;

        for(int p:piles){
            l = Math.min(l,p);
            r = Math.max(r,p);
        }

        int res=h;
        while(l<=r){

            int m = l + (r-l)/2;

            long hr=0;

            for(int p: piles){

                hr += (p+m-1)/m;
            }
            if(hr<=h){
                res=m;
                r=m-1;
            }else{
                l=m+1;
            }

        }
        return res;
    }
}
