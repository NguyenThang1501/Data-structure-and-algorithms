package PlusOne;

public class Test {
    public int[] plusOne(int[] digits) {
        int nums = 0;
        for (int i = 0; i < digits.length; i++) {
            nums = nums * 10 + digits[i];
        }
        nums = nums + 1;
        String value = String.valueOf(nums);
        int count = 0;
        while (nums != 0) {
            count++;
            nums = nums / 10;
        }
        int[] newArray = new int[count];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = Integer.parseInt(String.valueOf(value.charAt(i)));
        }
        return newArray;
    }
}
