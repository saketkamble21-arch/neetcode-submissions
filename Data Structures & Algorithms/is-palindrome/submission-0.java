class Solution {
    public boolean isPalindrome(String string) {
        String s = string.toLowerCase();

		char[] ch = s.toCharArray();
		int l = s.length();
		StringBuffer sb = new StringBuffer();

		int i = 0;
		for (char c : ch) {

			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				sb.append(c);
				i++;
			}
		}

		// System.out.println(sb);

		boolean b = checkPalindrom(sb);
        return b;
    }

    private static boolean checkPalindrom(StringBuffer s) {

		// System.out.println(s);
		String s1 = new String(s);
		int l = s1.length();
		char[] ch = s1.toCharArray();
		char[] rev = new char[l];

		int i = 0;

		while (l > 0) {
			rev[l - 1] = ch[i];
			i++;
			l--;
		}

		int compare = Arrays.compare(ch, rev);

		if (compare == 0) {
			return true;
		} else {
			return false;
		}

	}
}
