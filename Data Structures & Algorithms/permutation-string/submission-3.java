class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
		int n2 = s2.length();

		int s1Count[] = new int[26];
		int windowCount[] = new int[26];

		if (n1 > n2) {
			return false;
		}

		for (int i = 0; i < n1; i++) {

			// Step 1: Populate frequency arrays for s1 and the first window of s2
			s1Count[s1.charAt(i) - 'a']++;
			windowCount[s2.charAt(i) - 'a']++;
		}
		// Step 2: Check if the first window matches
		if (matches(s1Count, windowCount)) {
			return true;
		}

		// Step 3: Slide the window across s2
		int left = 0;
		for (int right = n1; right < n2; right++) {
			// Add the new character entering the window on the right
			windowCount[s2.charAt(right) - 'a']++;

			// Remove the old character entering the window on the right
			windowCount[s2.charAt(left) - 'a']--;
			left++;

			if (matches(s1Count, windowCount)) {
				return true;
			}
		}
		
		return false;
	}
    
    private static boolean matches(int[] s1Count, int[] windowCount) {

		for (int i = 0; i < 26; i++) {
			if (s1Count[i] != windowCount[i])
				return false;
		}
		return true;
	}

}
