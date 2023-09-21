package project2;

public class Quick {
	
	public static void sort(Comparable[] a)
	{
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int low, int high)
	{
		if(high <= low)
			return;
		int j = partition(a, low, high);
		sort(a, low, j-1); // �ǹ����� ���� �κ� ���ȣ��
		sort(a, j+1, high); // �ǹ����� ū �κ� ���ȣ��
	}
	
	private static int partition(Comparable[] a, int pivot, int high)
	{
		int i = pivot + 1;
		int j = high;
		Comparable p = a[pivot];
		while(true)
		{
			while(i < high && a[i].compareTo(p) <= 0) // �ǹ����� �۰ų� ������ i++
				i++;
			while(j > pivot && p.compareTo(a[j]) < 0) // �ǹ����� ũ�� j--
				j--;
			if(i >= j) // i�� j�� �����Ǹ� ���� ������
				break;
			swap(a, i, j); 
		}
		swap(a, pivot, j); // �ǹ��� a[j] ��ȯ
		return j;		   // a[j]�� �ǹ��� ������ �ڸ� ���� ��
	}
	
	private static void swap(Comparable [] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
