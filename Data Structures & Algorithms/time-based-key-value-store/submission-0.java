class TimeMap {

    private HashMap<String, List<Pair<Integer, String>>> storeMap;
    
    public TimeMap() {
        storeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        storeMap.computeIfAbsent(key, l -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String value = "";
        List<Pair<Integer, String>> values = storeMap.getOrDefault(key, new ArrayList<>());

        int left = 0, right = values.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(values.get(mid).getKey() < timestamp) {
                value = values.get(mid).getValue();
                left = mid + 1;
            } else if(values.get(mid).getKey() > timestamp) {
                right = mid - 1;
            } else {
                return values.get(mid).getValue();
            }
        }

        return value;
    }
}
