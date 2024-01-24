package palindromeNumber;


class Solution {
    public static boolean isPalindrome(int x) {
        int value = x;
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        while (x > 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x / 10;
        }
        System.out.println(reverse);

        return reverse == value;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}