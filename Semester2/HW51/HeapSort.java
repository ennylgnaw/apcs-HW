//Lynne Wang
//APCS2 pd1
//HW #51: Heaping Piles of Sordidness
//2018-05-21

import java.util.ArrayList;
import java.util.*;

/*******************************************************
 * Algo:
 * 1. Construct minheap from values
 * 2. While heap size is not empty:
 *       remove min from minheap, and add to retArr
 *******************************************************/

public class HeapSort {

    public static int[] heapSort( ALHeapMin minHeap ) {
	int[] retArr = new int[minHeap.getSize()]; 
	for (int i = 0; i < retArr.length; i++)
	    retArr[i] = minHeap.removeMin();
	return retArr;
    } //O(nlogn)

    public static ALHeapMin heapify( int[] arr ) {
	ALHeapMin minHeap = new ALHeapMin();
	for( int i : arr )
	    minHeap.add(i);
	return minHeap;
    }

    public static String stringify( int[] arr ) {
	String retStr = "";
	for( int i : arr )
	    retStr += i + " ";
	return retStr;
    }

    public static void main( String[] args ) {

	int[] nums = {10, 3, 6, 2, 1, 9, 0, 5, 8, 7};

	ALHeapMin pile = heapify(nums);
	
	int[] sorted = heapSort(pile);
	System.out.print("After sorting: ");
	System.out.println(stringify(sorted));
    }

}

    
