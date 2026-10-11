class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIdx = new int[26];
        for(int i = 0; i < order.length(); i++) {
            orderIdx[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];

            for(int j = 0; j < w1.length(); j++) {
                if(j == w2.length()) {
                    return false;
                }

                if(w1.charAt(j) != w2.charAt(j)) {
                    if(orderIdx[w1.charAt(j) - 'a'] > orderIdx[w2.charAt(j) - 'a']) {
                        return false;
                    }

                    break;
                }
            }
        }

        return true;
    }
}