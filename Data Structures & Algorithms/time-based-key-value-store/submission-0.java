class TimeMap {

	public HashMap<String, TreeMap<Integer, String>> map;

	public TimeMap() {
		this.map = new HashMap();
	}

	public void set(String key, String value, int timestamp) {

		map.putIfAbsent(key, new TreeMap<>());
		map.get(key).put(timestamp, value);
	}

    public String get(String key, int timestamp) {

		if (!map.containsKey(key)) {
			return "";
		}

		TreeMap<Integer, String> treeMap = map.get(key);
		Map.Entry<Integer, String> floorEntry = treeMap.floorEntry(timestamp);
			
		if (floorEntry == null) {
			return "";
		}

		return floorEntry.getValue();
	}
}
