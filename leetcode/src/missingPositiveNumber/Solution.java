package missingPositiveNumber;

class Solution {
    public static int findKthPositive(int[] arr, int k) {
        int dis = arr[0] - 1;
        int i = 1;
        while ( i < arr.length) {
            dis += arr[i] - arr[i - 1] - 1;
            i++;
        }
        if (dis >= k) {
            return arr[i - 2] + 1 + (dis - k);
        } else {
            return arr[arr.length - 1] - dis + k;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
    }
}