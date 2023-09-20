package project2;

public class NaturalMerge {
	
	   public static void sort(Comparable[] elements) {
	        int numElements = elements.length;

	        Comparable[] tmp = new Comparable[numElements];
	        int[] starts = new int[numElements + 1];

	        int runCount = 0;
	        starts[0] = 0;
	        for (int i = 1; i <= numElements; i++) {
	           if (i == numElements || elements[i].compareTo(elements[i - 1]) < 0) {
	               starts[++runCount] = i;
	             }
	        }

	        Comparable[] from = elements;
	        Comparable[] to = tmp;

	        while (runCount > 1) {
	           int newRunCount = 0;

	             for (int i = 0; i < runCount-1; i += 2) {
	               merge(from, to, starts[i], starts[i+1], starts[i+2]);
	               starts[newRunCount++] = starts[i];
	             }

	          if (runCount%2 == 1) {
	            int lastStart = starts[runCount-1];
	            System.arraycopy(from, lastStart, to, lastStart, numElements-lastStart);
	            starts[newRunCount++] = lastStart;
	          }

	          starts[newRunCount] = numElements;
	          runCount = newRunCount;

	          Comparable[] help = from;
	          from = to;
	          to = help;
	        }

	        if (from != elements) {
	          System.arraycopy(from, 0, elements, 0, numElements);
	        }
	    }
	   
	   private static void merge(Comparable[] source, Comparable[] target, int startLeft, int startRight, int endRight ) {
	      int leftPos = startLeft;
	       int rightPos = startRight;
	       int targetPos = startLeft;
	       
	       while (leftPos < startRight && rightPos < endRight) {
	           Comparable leftValue = source[leftPos];
	           Comparable rightValue = source[rightPos];
	           if (leftValue.compareTo(rightValue) < 0 || leftValue.compareTo(rightValue) == 0) {
	             target[targetPos++] = leftValue;
	             leftPos++;
	           } else {
	             target[targetPos++] = rightValue;
	             rightPos++;
	           }
	         }
	       
	       while(leftPos < startRight) {
	           target[targetPos++] = source[leftPos++];
	         }
	       while(rightPos < endRight) {
	           target [targetPos++] = source[rightPos++];
	         }
	    }

	}
