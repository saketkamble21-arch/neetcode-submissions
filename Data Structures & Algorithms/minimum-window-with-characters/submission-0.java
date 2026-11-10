class Solution {
    public String minWindow(String s, String t) {
        
        if (s == null || t == null || s.length() < t.length()) return "";

    int[] mapT = new int[128];
    for (char c : t.toCharArray()) {
        mapT[c]++;
    }

    int count = 0;
    int minLen = Integer.MAX_VALUE;
    int start = 0;
    int left = 0;
    int[] mapS = new int[128];

    for (int right = 0; right < s.length(); right++) {
        char rightChar = s.charAt(right);
        mapS[rightChar]++;

        // If this character is part of T and we haven't 
        // exceeded the count in T, increment our tracking count
        if (mapT[rightChar] > 0 && mapS[rightChar] <= mapT[rightChar]) {
            count++;
        }

        // When window is valid, try to shrink from the left
        while (count == t.length()) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                start = left;
            }

            char leftChar = s.charAt(left);
            mapS[leftChar]--;
            if (mapT[leftChar] > 0 && mapS[leftChar] < mapT[leftChar]) {
                count--;
            }
            left++;
        }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
}
}
    

