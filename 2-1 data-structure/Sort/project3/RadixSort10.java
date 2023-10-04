package project3;

public class RadixSort10 {

	public static void sort(int [] a)
	{
        int R = 10;
        int n = a.length;
        int[] t = new int[n];
        for (int k = 10; k <= 100000; k *= 10) {
            int[] startIndex = new int[R + 1];
            for (int i = 0; i < n; i++)
                startIndex[(a[i] % k) / (k / 10) + 1]++;
            for (int r = 0; r < R; r++)
                startIndex[r + 1] += startIndex[r];
            for (int i = 0; i < n; i++)
                t[startIndex[(a[i] % k) / (k / 10)]++] = a[i];
            for (int i = 0; i < n; i++)
                a[i] = t[i];
			
		}
	}
}


