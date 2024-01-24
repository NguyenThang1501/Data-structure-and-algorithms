package PlusOne;

public class Test1 {
    public boolean check(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                return false;
            }
        }
        return true;
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[n - 1] != 9) {
            digits[n - 1] += 1;
            return digits;
        } else if (check(digits)) {
            int[] newArray = new int[n + 1];
            newArray[0] = 1;
            return newArray;
        } else {
            int index = n - 1;
            while (digits[index] == 9) {
                digits[index] = 0;
                index--;
            }
            digits[index] = digits[index] + 1;
            return digits;
        }
    }
}
