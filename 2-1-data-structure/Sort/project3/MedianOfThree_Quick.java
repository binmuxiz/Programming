package project3;

public class MedianOfThree_Quick {
	
    private static void swap(int []arr, int a, int b)
    {
    	int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}	
    
    public static void sort(int [] arr)
    {
    	sort(arr, 0, arr.length-1);
    }
    
	private static void sort(int []arr, int front, int rear)
	{
		int pivot;
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
				while(arr[++i] < pivot && i<rear);
				while(arr[--j] > pivot && front<j);
				if(i>=j) break;
				swap(arr, i, j);
			}
			swap(arr, i, rear-1);
			sort(arr, front, i-1);
			sort(arr, i+1, rear);
		}
	}	
	
	private static void threeSort(int []arr, int front, int mid, int rear)
	{
		if(arr[front] > arr[mid]) 
			swap(arr, front, mid);
		if(arr[mid] > arr[rear]) 
			swap(arr, mid, rear);
		if(arr[front] > arr[mid]) 
			swap(arr, front, mid);
	}
	
}
