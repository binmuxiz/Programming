package project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main { // 자료형별 정렬시간

	static int size = 50000;
	
	public static void main(String[] args) {
		
		long beforeTime, afterTime, secDiffTime;
		
		// 1. Bubble Sort
		SortManager bubble = new SortManager(size);
		System.out.println("1. Bubble Sort");
	
		// Random
        beforeTime = System.currentTimeMillis();
        bubble.int_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        bubble.double_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bubble.string_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bubble.student_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        bubble.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        bubble.int_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        bubble.double_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bubble.string_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bubble.student_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        bubble.descendingOrder();

        beforeTime = System.currentTimeMillis();
        bubble.int_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        bubble.double_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bubble.string_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bubble.student_bubbleSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
		
        
		
        System.out.println("=======================================");
		SortManager insertion = new SortManager(size);
		System.out.println("2. Insertion Sort");
		
		// Random
        beforeTime = System.currentTimeMillis();
        insertion.int_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        insertion.double_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        insertion.string_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        insertion.student_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        insertion.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        insertion.int_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        insertion.double_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        insertion.string_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        insertion.student_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        insertion.descendingOrder();

        beforeTime = System.currentTimeMillis();
        insertion.int_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        insertion.double_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        insertion.string_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        insertion.student_insertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
        
        
        System.out.println("====================================");
		SortManager bs_insertion = new SortManager(size);
		System.out.println("3. Binary Search Insertion Sort");
		
		// Random
        beforeTime = System.currentTimeMillis();
        bs_insertion.int_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        bs_insertion.double_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bs_insertion.string_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bs_insertion.student_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        insertion.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        bs_insertion.int_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        bs_insertion.double_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bs_insertion.string_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bs_insertion.student_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
	
		
		// Descending Order
        bs_insertion.descendingOrder();

        beforeTime = System.currentTimeMillis();
        bs_insertion.int_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        bs_insertion.double_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bs_insertion.string_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        bs_insertion.student_bsInsertionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
        
        
        System.out.println("=======================================");
		SortManager seletion = new SortManager(size);
		System.out.println("4. Selection Sort");
	
		// Random
        beforeTime = System.currentTimeMillis();
        seletion.int_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        seletion.double_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        seletion.string_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        seletion.student_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        seletion.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        seletion.int_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        seletion.double_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        seletion.string_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        seletion.student_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        seletion.descendingOrder();

        beforeTime = System.currentTimeMillis();
        seletion.int_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        seletion.double_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        seletion.string_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        seletion.student_selectionSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
	
        
        
        
        System.out.println("=======================================");
		SortManager heap = new SortManager(size);
		System.out.println("5. Heap Sort");
		
		
		
		// Random
        beforeTime = System.currentTimeMillis();
        heap.int_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        heap.double_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        heap.string_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        heap.student_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        heap.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        heap.int_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        heap.double_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        heap.string_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        heap.student_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        heap.descendingOrder();

        beforeTime = System.currentTimeMillis();
        heap.int_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        heap.double_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        heap.string_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        heap.student_heapSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
		
        
        
        
        System.out.println("===================================");
		SortManager shell = new SortManager(size);
		System.out.println("6. Shell Sort");
		
		
		// Random
        beforeTime = System.currentTimeMillis();
        shell.int_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        shell.double_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        shell.string_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        shell.student_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        shell.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        shell.int_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        shell.double_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        shell.string_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        shell.student_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
	
		
		// Descending Order
        shell.descendingOrder();

        beforeTime = System.currentTimeMillis();
        shell.int_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        shell.double_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        shell.string_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        shell.student_shellSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
		
		
        
        System.out.println("===================================");
        SortManager quick = new SortManager(size);
        System.out.println("7. Quick Sort");
        
		
		// Random
        beforeTime = System.currentTimeMillis();
        quick.int_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        quick.double_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        quick.string_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
      
        beforeTime = System.currentTimeMillis();
        quick.student_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        quick.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        quick.int_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        quick.double_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        quick.string_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        quick.student_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        quick.descendingOrder();

        beforeTime = System.currentTimeMillis();
        quick.int_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        quick.double_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        quick.string_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        quick.student_quickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
        
        
        
        
        System.out.println("===================================");
        System.out.println("8. MedianOfThree Quick Sort");  
        SortManager medianOfThreeQuick = new SortManager(size);
        
        
		// Random
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.int_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.double_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.string_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.student_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        medianOfThreeQuick.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.int_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.double_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.string_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.student_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        medianOfThreeQuick.descendingOrder();

        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.int_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
	
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.double_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.string_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        medianOfThreeQuick.student_medianOfThreeQuickSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
        
        
        
        System.out.println("===================================");
        System.out.println("9. Recursive Merge Sort");
        SortManager RecursiveMerge = new SortManager(size);
        
    	// Random
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.int_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.double_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.string_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.student_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        RecursiveMerge.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.int_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.double_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.string_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.student_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        RecursiveMerge.descendingOrder();

        beforeTime = System.currentTimeMillis();
        RecursiveMerge.int_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.double_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.string_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        RecursiveMerge.student_recursiveMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
        
        
        
        
        System.out.println("===================================");
        System.out.println("10. Iterative Merge Sort");
        SortManager iterativeMerge = new SortManager(size);
        
        
        
    	// Random
        beforeTime = System.currentTimeMillis();
        iterativeMerge.int_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        iterativeMerge.double_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        iterativeMerge.string_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        iterativeMerge.student_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        iterativeMerge.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        iterativeMerge.int_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        iterativeMerge.double_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        iterativeMerge.string_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        iterativeMerge.student_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        iterativeMerge.descendingOrder();

        beforeTime = System.currentTimeMillis();
        iterativeMerge.int_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
	
        beforeTime = System.currentTimeMillis();
        iterativeMerge.double_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        iterativeMerge.string_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        iterativeMerge.student_iterativeMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
        
        
        
        System.out.println("===================================");
        System.out.println("11. Natural Merge Sort");
        SortManager naturalMerge = new SortManager(size);
        
        
    	// Random
        beforeTime = System.currentTimeMillis();
        naturalMerge.int_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        naturalMerge.double_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        naturalMerge.string_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        naturalMerge.student_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        naturalMerge.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        naturalMerge.int_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
	
        beforeTime = System.currentTimeMillis();
        naturalMerge.double_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        naturalMerge.string_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        naturalMerge.student_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        naturalMerge.descendingOrder();

        beforeTime = System.currentTimeMillis();
        naturalMerge.int_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        naturalMerge.double_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        naturalMerge.string_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        naturalMerge.student_naturalMergeSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);

        
        System.out.println("===================================");
		SortManager arrays = new SortManager(size);
		System.out.println("12. Arrays.Sort");
		
		
    	// Random
        beforeTime = System.currentTimeMillis();
        arrays.int_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        arrays.double_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        arrays.string_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        arrays.student_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        
		// Ascending Order
        arrays.ascendingOrder();
        
        beforeTime = System.currentTimeMillis();
        arrays.int_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        arrays.double_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        arrays.string_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        arrays.student_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
        arrays.descendingOrder();

        beforeTime = System.currentTimeMillis();
        arrays.int_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
        arrays.double_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        arrays.string_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
        arrays.student_arraysSort();
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
	
        
        
        
        System.out.println("===================================");
		System.out.println("13. Collections.Sort");
		
        List <Integer> intList = new ArrayList();
        for(int i = 0; i < size; i++)
			intList.add((int)(Math.random() * 100)) ;
		
        List<Double> doubleList = new ArrayList();
        for(int i = 0; i < size; i++)
			doubleList.add(Math.random() * 100);
		
		List<String> stringList = new ArrayList();
		Random rnd = new Random();
		for(int i = 0; i < size; i++)
		{
			String temp = "";
			for(int j = 0; j < 10; j++)
			{
				temp += String.valueOf((char)('a' + rnd.nextInt(26)));
			}
			stringList.add(temp);
		}
		
		List<Student> stuList = new ArrayList();
		int kor, eng, math, history, science;
		
		for(int i = 0; i < size; i++)
		{
			kor = rnd.nextInt(101);
			eng = rnd.nextInt(101);
			math = rnd.nextInt(101);
			history = rnd.nextInt(101);
			science = rnd.nextInt(101);
			stuList.add(new Student(kor, eng, math, history, science));
		}
		
		
		// Random
        beforeTime = System.currentTimeMillis();
		Collections.sort(intList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
		Collections.sort(doubleList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
		Collections.sort(stringList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_string : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
		Collections.sort(stuList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Random time_student : "+secDiffTime);
        

		// Ascending Order
        beforeTime = System.currentTimeMillis();
		Collections.sort(intList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_int : "+secDiffTime);
	
        beforeTime = System.currentTimeMillis();
		Collections.sort(doubleList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
		Collections.sort(stringList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_string : "+secDiffTime);
      
        beforeTime = System.currentTimeMillis();
		Collections.sort(stuList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Increase time_student : "+secDiffTime);
		
		
		// Descending Order
		Collections.sort(intList, Collections.reverseOrder());
		Collections.sort(doubleList, Collections.reverseOrder());
		Collections.sort(stringList, Collections.reverseOrder());
		Collections.sort(stuList, Collections.reverseOrder());
		
        beforeTime = System.currentTimeMillis();
		Collections.sort(intList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_int : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
		Collections.sort(doubleList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_double : "+secDiffTime);
        
        beforeTime = System.currentTimeMillis();
		Collections.sort(stringList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_string : "+secDiffTime);
		
        beforeTime = System.currentTimeMillis();
		Collections.sort(stuList);
        afterTime = System.currentTimeMillis();
        secDiffTime = (afterTime - beforeTime);
        System.out.println("Decrease time_student : "+secDiffTime);
	}
	

}
