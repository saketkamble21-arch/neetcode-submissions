class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1==null || s2==null || s1.length()>s2.length()){
            return false;
        }
        
        int n1 = s1.length();
        int n2 = s2.length();

        char ch[] = s1.toCharArray();
        Arrays.sort(ch);
        String sortedS1 = new String(ch);
        System.out.println(sortedS1);

        for(int i=0;i<=n2-n1;i++){

            String window = s2.substring(i,i+n1);

            char c[] = window.toCharArray();
            Arrays.sort(c);
            String sortedWindow = new String(c);
            System.out.println(sortedWindow);
            if(sortedS1.equals(sortedWindow)){
                return true;
            }
        }

        return false;
    }
}
