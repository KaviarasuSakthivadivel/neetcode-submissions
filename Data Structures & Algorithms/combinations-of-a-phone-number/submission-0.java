public class Solution {
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        backtrack(0, "", digits, result);
        
        return result;
    }

    private void backtrack(int i, String curStr, String digits, List<String> result) {
        if(curStr.length() == digits.length()) {
            result.add(curStr);
            return;
        }

        String currentDigits = digitToChar[digits.charAt(i) - '0'];
        for(char ch : currentDigits.toCharArray()) {
            backtrack(i + 1, curStr + ch, digits, result);
        }
    }
}