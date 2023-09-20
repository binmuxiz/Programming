package project2;

public class MedianOfThree_Quick 
{
	
    private static void swap(Comparable []arr, int a, int b)
    {
    	Comparable tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}	
    
    public static void sort(Comparable [] arr)
    {
    	sort(arr, 0, arr.length-1);
    }
    
	private static void sort(Comparable []arr, int front, int rear)
	{
		Comparable pivot;
		int i, j, mid = front+(rear-front)/2;	
		threeSort(arr, front, mid, rear);		
		
		if(rear-front+1>3)
		{
			pivot = arr[mid];
			swap(arr, mid, rear-1);
			i = front;
			j = rear-1;	
			
			while(true)
			{
				while(arr[++i].compareTo(pivot) < 0 && i<rear);
				while(arr[--j].compareTo(pivot) > 0 && front<j);
				if(i>=j) break;
				swap(arr, i, j);
			}
			swap(arr, i, rear-1);
			sort(arr, front, i-1);
			sort(arr, i+1, rear);
		}
	}	
	
	private static void threeSort(Comparable []arr, int front, int mid, int rear)
	{
		if(arr[front].compareTo(arr[mid]) > 0) 
			swap(arr, front, mid);
		if(arr[mid].compareTo(arr[rear]) > 0) 
			swap(arr, mid, rear);
		if(arr[front].compareTo(arr[mid]) > 0) 
			swap(arr, front, mid);
	}
}
