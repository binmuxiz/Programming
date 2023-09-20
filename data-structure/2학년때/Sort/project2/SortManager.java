package project2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortManager
{
	Integer [] array1;
	Double [] array2;
	String [] array3;
	Student [] array4;
	
	public SortManager(int size)
	{
		array1 = new Integer[size];
		array2 = new Double[size];
		array3 = new String[size];
	    array4 = new Student[size];
	    rndIntArray();
	    rndDoubleArray();
	    rndStringArray();
	    rndStudentArray();
	}
	
	private void rndIntArray()
	{
		for(int i = 0; i < array1.length; i++)
			array1[i] = (int) (Math.random() * 100);
	}
	
	private void rndDoubleArray()
	{
		for(int i = 0; i < array2.length; i++)
			array2[i] = Math.random() * 100;
	}
	
	private void rndStringArray()
	{
		Random rnd = new Random();
		
		for(int i = 0; i < array3.length; i++)
		{
			String temp = "";
			for(int j = 0; j < 10; j++)
			{
				temp += String.valueOf((char)('a' + rnd.nextInt(26)));
			}
			array3[i] = temp;
		}
	}

	private void rndStudentArray()
	{
		Random rnd = new Random();
		int kor, eng, math, history, science;
		
		for(int i = 0; i < array4.length; i++)
		{
			kor = rnd.nextInt(101);
			eng = rnd.nextInt(101);
			math = rnd.nextInt(101);
			history = rnd.nextInt(101);
			science = rnd.nextInt(101);
			array4[i] = new Student(kor, eng, math, history, science);
		}
	}
	 
	public void ascendingOrder()
	{
		Arrays.sort(array1);
		Arrays.sort(array2);
		Arrays.sort(array3);
		Arrays.sort(array4);
	}
	
	public void descendingOrder()
	{
		Arrays.sort(array1, Collections.reverseOrder());
		Arrays.sort(array2, Collections.reverseOrder());
		Arrays.sort(array3, Collections.reverseOrder());
		Arrays.sort(array4, Collections.reverseOrder());
	}
	

	public void bubbleSort()
	{
		Bubble.sort(array1);
		Bubble.sort(array2);
		Bubble.sort(array3);
		Bubble.sort(array4);
	}
	
	public void int_bubbleSort()
	{
		Bubble.sort(array1);
	}
	
	public void double_bubbleSort()
	{
		Bubble.sort(array2);
	}
	
	public void string_bubbleSort()
	{
		Bubble.sort(array3);
	}
	
	public void student_bubbleSort()
	{
		Bubble.sort(array4);
	}
	
	public void insertionSort()
	{
		Insertion.sort(array1);
		Insertion.sort(array2);
		Insertion.sort(array3);
		Insertion.sort(array4);
	}
	
	public void int_insertionSort()
	{
		Insertion.sort(array1);
	}
	
	public void double_insertionSort()
	{
		Insertion.sort(array2);
	}
	
	public void string_insertionSort()
	{
		Insertion.sort(array3);
	}
	
	public void student_insertionSort()
	{
		Insertion.sort(array4);
	}
	
	public void bs_insertionSort()
	{
		BS_Insertion.sort(array1);
		BS_Insertion.sort(array2);
		BS_Insertion.sort(array3);
		BS_Insertion.sort(array4);
	}
	
	public void int_bsInsertionSort()
	{
		BS_Insertion.sort(array1);
	}
	
	public void double_bsInsertionSort()
	{
		BS_Insertion.sort(array2);
	}
	
	public void string_bsInsertionSort()
	{
		BS_Insertion.sort(array3);
	}
	
	public void student_bsInsertionSort()
	{
		BS_Insertion.sort(array4);
	}

	public void selectionSort()
	{
		Selection.sort(array1);
		Selection.sort(array2);
		Selection.sort(array3);
		Selection.sort(array4);
	}
	
	public void int_selectionSort()
	{
		Selection.sort(array1);
	}
	
	public void double_selectionSort()
	{
		Selection.sort(array2);
	}
	
	public void string_selectionSort()
	{
		Selection.sort(array3);
	}
	
	public void student_selectionSort()
	{
		Selection.sort(array4);
	}
	
	public void heapSort()
	{
		Heap.sort(array1);
		Heap.sort(array2);
		Heap.sort(array3);
		Heap.sort(array4);
	}
	
	public void int_heapSort()
	{
		Heap.sort(array1);
	}
	
	public void double_heapSort()
	{
		Heap.sort(array2);
	}
	
	public void string_heapSort()
	{
		Heap.sort(array3);
	}
	
	public void student_heapSort()
	{
		Heap.sort(array4);
	}
	
	public void shellSort()
	{
		Shell.sort(array1);
		Shell.sort(array2);
		Shell.sort(array3);
		Shell.sort(array4);
	}
	
	public void int_shellSort()
	{
		Shell.sort(array1);
	}
	
	public void double_shellSort()
	{
		Shell.sort(array2);
	}
	
	public void string_shellSort()
	{
		Shell.sort(array3);
	}
	
	public void student_shellSort()
	{
		Shell.sort(array4);
	}
	
	public void quickSort()
	{
		Quick.sort(array1);
		Quick.sort(array2);
		Quick.sort(array3);
		Quick.sort(array4);
	}
	
	public void int_quickSort()
	{
		Quick.sort(array1);
	}
	
	public void double_quickSort()
	{
		Quick.sort(array2);
	}
	
	public void string_quickSort()
	{
		Quick.sort(array3);
	}
	
	public void student_quickSort()
	{
		Quick.sort(array4);
	}
	
	public void medianOfThreeQuickSort()
	{
		MedianOfThree_Quick.sort(array1);
		MedianOfThree_Quick.sort(array2);
		MedianOfThree_Quick.sort(array3);
		MedianOfThree_Quick.sort(array4);
	}
	
	public void int_medianOfThreeQuickSort()
	{
		MedianOfThree_Quick.sort(array1);
	}
	
	public void double_medianOfThreeQuickSort()
	{
		MedianOfThree_Quick.sort(array2);
	}
	
	public void string_medianOfThreeQuickSort()
	{
		MedianOfThree_Quick.sort(array3);
	}
	
	public void student_medianOfThreeQuickSort()
	{
		MedianOfThree_Quick.sort(array4);
	}
	
	public void recursiveMergeSort()
	{
		RecursiveMerge.sort(array1);
		RecursiveMerge.sort(array2);
		RecursiveMerge.sort(array3);
		RecursiveMerge.sort(array4);
	}
	
	public void int_recursiveMergeSort()
	{
		RecursiveMerge.sort(array1);
	}
	
	public void double_recursiveMergeSort()
	{
		RecursiveMerge.sort(array2);
	}
	
	public void string_recursiveMergeSort()
	{
		RecursiveMerge.sort(array3);
	}
	
	public void student_recursiveMergeSort()
	{
		RecursiveMerge.sort(array4);
	}
	
	public void iterativeMergeSort()
	{
		IterativeMerge.sort(array1);
		IterativeMerge.sort(array2);
		IterativeMerge.sort(array3);
		IterativeMerge.sort(array4);
	}

	public void int_iterativeMergeSort()
	{
		IterativeMerge.sort(array1);
	}
	
	public void double_iterativeMergeSort()
	{
		IterativeMerge.sort(array2);
	}
	
	public void string_iterativeMergeSort()
	{
		IterativeMerge.sort(array3);
	}
	
	public void student_iterativeMergeSort()
	{
		IterativeMerge.sort(array4);
	}
	
	public void naturalMergeSort()
	{
		NaturalMerge.sort(array1);
		NaturalMerge.sort(array2);
		NaturalMerge.sort(array3);
		NaturalMerge.sort(array4);
	}
	
	public void int_naturalMergeSort()
	{
		NaturalMerge.sort(array1);
	}
	
	public void double_naturalMergeSort()
	{
		NaturalMerge.sort(array2);
	}
	
	public void string_naturalMergeSort()
	{
		NaturalMerge.sort(array3);
	}
	
	public void student_naturalMergeSort()
	{
		NaturalMerge.sort(array4);
	}
	
	
	public void arraysSort()
	{
		Arrays.sort(array1);
		Arrays.sort(array2);
		Arrays.sort(array3);
		Arrays.sort(array4);
	}

	public void int_arraysSort()
	{
		Arrays.sort(array1);
	}
	
	public void double_arraysSort()
	{
		Arrays.sort(array2);
	}
	
	public void string_arraysSort()
	{
		Arrays.sort(array3);
	}
	
	public void student_arraysSort()
	{
		Arrays.sort(array4);
	}
}



