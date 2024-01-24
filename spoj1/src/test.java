import java.util.Arrays;

public class test {
    static int countTriplets(int[] arr, int n, int sum) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                j++;
                if (arr[i] + arr[j] + arr[k] > sum) {
                    k--;
                }
                else {
                    return (arr[i] + arr[j] + arr[k]);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{40,50,60,80};
        int sum = 160;
        System.out.println(countTriplets(arr, arr.length, sum));
    }
}
