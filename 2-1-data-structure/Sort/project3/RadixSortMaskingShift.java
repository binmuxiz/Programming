package project3;

public class RadixSortMaskingShift {
	
	static void ccsort16(int a[], int n, int shift)
	{
		int [] count = new int[16];
		int [] output = new int[n];
		int i, last;
		
		for(i = 0; i < n; i++)
			++count[(a[i] >> shift) & 15];
		for(i = last = 0; i < 16; i++)
		{
			last += count[i];
			count[i] = last - count[i];
		}
		for(i = 0; i < n; i++)
			output[count[(a[i] >> shift) & 15]++] = a[i];
		for(i = 0; i < n; i++)
			a[i] = output[i];
			
	}
	
	static void rsort16(int [] a, int n)
	{
		int max = a[0];
		for(int i = 1; i < n; i++)
		{
			if(a[i] > max)
				max = a[i];
		}
		for(int shift = 0; (max >> shift) > 0; shift += 4)
			ccsort16(a, n, shift);
	}
}
