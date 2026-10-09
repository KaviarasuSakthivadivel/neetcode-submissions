class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, new ArrayList<String>(), result, s);

        return result;
    }

    private void dfs(int start, List<String> currentList, List<List<String>> result, String s) {
        if(start >= s.length()) {
            result.add(new ArrayList<String>(currentList));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1)); // Avoid OBO (off-by-one) error

                dfs(end + 1, currentList, result, s);

                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}