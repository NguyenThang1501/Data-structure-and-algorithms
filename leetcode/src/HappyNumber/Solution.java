package HappyNumber;

class Solution {
    public int squareDigits(int n) {
        int s = 0;
        while (n > 0) {
            s += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return s;
    }

    public boolean isHappy(int n) {
        while (n > 9) {
            n = squareDigits(n);
        }
        return n == 1;
    }
}