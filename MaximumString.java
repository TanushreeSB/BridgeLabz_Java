public class MaximumString {

    public static String testMaximum(String a, String b, String c) {
        String max = a;

        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;

        return max;
    }
}