import java.util.Arrays;

public class Challenge {

    // Linear Search: first missing positive
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];

        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) return i;
        }

        return n + 1;
    }

    // Binary Search after sorting
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};

        System.out.println("Missing Positive: " + firstMissingPositive(arr));
        System.out.println("Index: " + binarySearch(arr, 4));
    }
}