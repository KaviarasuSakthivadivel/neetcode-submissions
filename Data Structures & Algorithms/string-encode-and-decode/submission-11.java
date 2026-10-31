class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> decoded = new ArrayList<>();
        while(i < str.length()) {
            int j = i;

            while(str.charAt(j) != '#') {
                j++;
            }

            // Parse the integer between i and j
            Integer length = Integer.valueOf(str.substring(i, j));

            // start of the string is j + 1, and move the i pointer to next word
            i = j + 1 + length;
            decoded.add(str.substring(j + 1, i));
        }

        return decoded;
    }
}
