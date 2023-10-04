package project3;

public class Main {
	
	public static void main(String [] args)
	{
		int size = 50000;
		
		int [] array = new int[size];
		for(int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * (60000 - 10000 + 1) + 10000);
		
		int [] temp1 = new int[size];
		for(int i = 0; i < temp1.length; i++)
			temp1[i] = array[i];
		
		int [] temp2 = new int[size];
		for(int i = 0; i < temp2.length; i++)
			temp2[i] = array[i];
		
		int [] temp3 = new int[size];
		for(int i = 0; i < temp3.length; i++)
			temp3[i] = array[i];
		
		int [] temp4 = new int[size];
		for(int i = 0; i < temp4.length; i++)
			temp4[i] = array[i];
		
		long beforeTime, afterTime, secDiffTime;
		
        beforeTime = System.currentTimeMillis();
		RadixSort16.sort(temp1);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("1. radix sort 수행 시간(1)(ms) : " + secDiffTime);
        
        beforeTime = System.currentTimeMillis();
		RadixSortMaskingShift.rsort16(temp2, size);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("\n2. radix sort 수행 시간(2)(ms) : " + secDiffTime);
        
        beforeTime = System.currentTimeMillis();
		RadixSort10.sort(temp3);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("\n3. radix sort 수행 시간(3)(ms) : " + secDiffTime);
        
        beforeTime = System.currentTimeMillis();
		MedianOfThree_Quick.sort(temp4);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("\n4. median of three quick sort 수행 시간(ms) : " + secDiffTime);
       
	}
	
}
