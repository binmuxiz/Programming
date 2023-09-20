package project2;

public class Bubble {
	
	public static void sort(Comparable [] a)
	{
		sort(a, a.length);
	}
	
	private static void sort(Comparable [] a, int size)
	{
		for(int i = 1; i < size; i++) 
		{
			for(int j = 0; j < size - i; j++) 
			{
				// 현재 원소가 다음 원소보다 클 경우
				// 서로 원소의 위치를 교환한다.
				
				if(a[j].compareTo(a[j+1]) > 0)
					swap(a, j, j+1);
			}
			
		}
	}
	
	private static void swap(Comparable [] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
