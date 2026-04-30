public class FirstLastOccurrence {

    static int first(int[] arr, int target) {
        int left = 0, right = arr.length - 1, res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    static int last(int[] arr, int target) {
        int left = 0, right = arr.length - 1, res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 8};
        int target = 4;

        System.out.println(first(arr, target));
        System.out.println(last(arr, target));
    }
}