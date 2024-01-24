package PlusOne;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[n - 1] != 9) {
            digits[n - 1] += 1;
            return digits;
        } else if (Arrays.equals(digits, new int[]{9})) {
            return new int[]{1, 0};
        } else {
            int[] newArray = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                newArray[i] = digits[i];
            }
            newArray[n] = 0;
            newArray[n - 1] = digits[n - 2] + 1;
            return newArray;
        }
    }
}