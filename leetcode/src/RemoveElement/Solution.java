package RemoveElement;

class Solution {

    public void remove(int[] a, int index) {
        for (int i = index; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
    }

    public int removeElement(int[] nums, int val) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                remove(nums, i);
            } else {
                count++;
            }
        }
        return count;
    }
}
