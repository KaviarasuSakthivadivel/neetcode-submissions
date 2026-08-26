record TimedValue(int timestamp, String value) {}

class TimeMap {

    private HashMap<String, ArrayList<TimedValue>> storeMap;
    
    public TimeMap() {
        storeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        storeMap.computeIfAbsent(key, l -> new ArrayList<>()).add(new TimedValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String value = "";
        List<TimedValue> values = storeMap.getOrDefault(key, new ArrayList<>());

        int left = 0, right = values.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(values.get(mid).timestamp() < timestamp) {
                value = values.get(mid).value();
                left = mid + 1;
            } else if(values.get(mid).timestamp() > timestamp) {
                right = mid - 1;
            } else {
                return values.get(mid).value();
            }
        }

        return value;
    }
}
