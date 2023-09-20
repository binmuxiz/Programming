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
				// ���� ���Ұ� ���� ���Һ��� Ŭ ���
				// ���� ������ ��ġ�� ��ȯ�Ѵ�.
				
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
