public class CountingSortAges {

    public static void countingSort(int[] arr, int min, int max) {
        int[] count = new int[max - min + 1];

        for (int num : arr) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 12};
        countingSort(ages, 10, 18);

        for (int a : ages) System.out.print(a + " ");
    }
}