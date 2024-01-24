package ValidParentheses;

class Solution {
    public boolean check(Character c1, Character c2, String s) {
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c1 == s.charAt(i)) {
                countLeft++;
            }
            if (c2 == s.charAt(i)) {
                countRight++;
            }
            if (countRight > countLeft) {
                return false;
            }
            if (s.charAt(i) == c1 && (s.charAt(i + 1) != c1 || s.charAt(i + 1) != c2)) {
                break;
            }
        }
        return countLeft == countRight;
    }

    public boolean isValid(String s) {
        return check('(', ')', s) && check('[', ']', s) && check('{', '}', s);
    }
}
