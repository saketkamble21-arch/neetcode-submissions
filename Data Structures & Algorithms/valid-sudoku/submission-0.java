class Solution {
    public boolean isValidSudoku(char[][] s) {
        
        int N = 9;

		HashSet<Character>[] row = new HashSet[N];
		HashSet<Character>[] col = new HashSet[N];
		HashSet<Character>[] mtx = new HashSet[N];

		for (int i = 0; i < N; i++) {
			row[i] = new HashSet<Character>();
			col[i] = new HashSet<Character>();
			mtx[i] = new HashSet<Character>();
		}

		for (int r = 0; r < N; r++) {

			for (int c = 0; c < N; c++) {

				char cell = s[r][c];

				if (cell == '.') {
					continue;
				}

				if (row[r].contains(cell)) {
					return false;
				}
				row[r].add(cell);
				
				if (col[c].contains(cell)) {
					return false;
				}
				col[c].add(cell);
				
				int ind = (r/3) * 3 + (c/3);
				if(mtx[ind].contains(cell)) {
					return false;
				}mtx[ind].add(cell);
			}
		}
		return true;
	}
    
}
