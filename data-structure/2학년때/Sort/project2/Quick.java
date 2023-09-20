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
		sort(a, low, j-1); // 피벗보다 작은 부분 재귀호출
		sort(a, j+1, high); // 피벗보다 큰 부분 재귀호출
	}
	
	private static int partition(Comparable[] a, int pivot, int high)
	{
		int i = pivot + 1;
		int j = high;
		Comparable p = a[pivot];
		while(true)
		{
			while(i < high && a[i].compareTo(p) <= 0) // 피벗보다 작거나 같으면 i++
				i++;
			while(j > pivot && p.compareTo(a[j]) < 0) // 피벗보다 크면 j--
				j--;
			if(i >= j) // i와 j가 교차되면 루프 나가기
				break;
			swap(a, i, j); 
		}
		swap(a, pivot, j); // 피벗과 a[j] 교환
		return j;		   // a[j]의 피벗이 영원히 자리 잡은 곳
	}
	
	private static void swap(Comparable [] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
