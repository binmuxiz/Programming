package project3;

public class RadixSort16 {

	public static void sort(int [] a)
	{
        int R = 16;
        int n = a.length;
        int[] t = new int[n];
        for (int k = 16; k <= 100000; k = k * 16) {
            int[] startIndex = new int[R + 1];
            for (int i = 0; i < n; i++)
                startIndex[(a[i] % k) / (k /16) + 1]++;
            for (int r = 0; r < R; r++)
                startIndex[r + 1] += startIndex[r];
            for (int i = 0; i < n; i++)
                t[startIndex[(a[i] % k) / (k /16)]++] = a[i];
            for (int i = 0; i < n; i++)
                a[i] = t[i];
				
		}
	}
}


