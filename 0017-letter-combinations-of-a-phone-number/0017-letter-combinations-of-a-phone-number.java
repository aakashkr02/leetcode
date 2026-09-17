import java.util.*;

class Solution {

    String[] letters = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, "", result);

        return result;
    }

    private void backtrack(
            String digits,
            int index,
            String current,
            List<String> result) {

        // All digits processed
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String chars = letters[digit];

        for (char c : chars.toCharArray()) {
            backtrack(
                digits,
                index + 1,
                current + c,
                result
            );
        }
    }
}