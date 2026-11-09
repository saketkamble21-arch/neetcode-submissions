class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n1= s1.length();
        int n2= s2.length();

        int s1Count[] = new int[26];
        int windowCount[] = new int[26];

        if(s1==null || s2==null || n1>n2){
            return false;
        }
        
        for(int i=0;i<n1;i++){
            s1Count[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<=n2-n1;i++){

            if(i==0){
                for(int j=i;j<n1;j++){
                    windowCount[s2.charAt(j)-'a']++;
                }
            }else{
                windowCount[s2.charAt(i-1)-'a']--;
                windowCount[s2.charAt(i+n1-1)-'a']++;

            }

            if(match(s1Count,windowCount)){
                return true;
            }
        }

        return false;
    }

    public boolean match(int a[],int b[]){

        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }

}
