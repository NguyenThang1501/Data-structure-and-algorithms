package RemoveElement;

public class test {
    public static void remove(int[] a, int index) {
        for (int i = index; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
    }

    public static int removeElement(int[] nums, int val) {
        int[] newArray = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                newArray[count] = nums[i];
                count++;
            }
        }
        print(newArray);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
        print(nums);
        return count;
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        removeElement(a,2);
        print(a);
    }
}
