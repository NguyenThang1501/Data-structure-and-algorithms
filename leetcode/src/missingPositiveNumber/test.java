package missingPositiveNumber;

public class test {
    public static int findKthPositive(int[] arr, int k) {
        if (arr.length == 1) {
            if (arr[0] - 1 >= k) {
                return k;
            }
            return arr[0] + k - (arr[0] - 1);
        }
        int dis = arr[0] - 1;
        int i = 1;
        while (i < arr.length) {
            if (dis > k) break;
            dis += arr[i] - arr[i - 1] - 1;
            i++;
        }
        if (dis < k) {
            return arr[i - 1] - dis + k;
        }
        return arr[i - 2] + 1 + dis - k;
    }

    public static void main(String[] args) {
        int[] arr = {3,10};
        System.out.println(findKthPositive(arr, 2));
    }
}
