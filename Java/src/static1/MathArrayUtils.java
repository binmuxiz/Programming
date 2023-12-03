package static1;

public class MathArrayUtils {

    private MathArrayUtils() {}

    public static int sum(int[] array) {
        int sum = 0;
        for (int item : array) {
            sum += item;
        }
        return sum;
    }

    public static double average(int[] array) {
        return (double) sum(array) / array.length;
    }

    public static int min(int[] array) {
        int minVal = array[0];
        for (int item : array) {
            minVal = (minVal > item) ? item : minVal;
        }
        return minVal;
    }

    public static int max(int[] array) {
        int maxVal = array[0];
        for (int item : array) {
            maxVal = (maxVal < item) ? item : maxVal;
        }
        return maxVal;
    }
}

