//Team Naked Frog (Lynne Wang, Simon Tsui)
//APCS1 pd1
//HW55: Never Fear, Big Oh Is Here!
//2017-12-15

import java.util.*;

public class MySorts {

    //=================== HELPER METHODS ===================
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }
    
    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //======================================================

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    
    // BEST CASE: O(n) - makes n-1 passes and 0 swaps; when the array list is already sorted (in ascending order).
    
    // WORST CASE: O(n^2) - makes n-1 passes and n-1 swaps per pass; when the array list is sorted in descending order.
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) 
		    data.set( i, data.set(i+1,data.get(i)) );	
		System.out.println(data); //diag: show current state of list
	    }
	}
    }//end bubbleSort

    //======================================================
    
    // VOID version of selectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    
    // BEST CASE AND WORST CASE (same): O(n^2) comparisons, O(n) swaps - go through n-1 passes with varying comparisons, n-1 swaps. If the element is in the correct position, self swaps will still occur.
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		System.out.println( "maxPos: " + maxPos );//diag
		System.out.println( data );//diag
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println( "after swap: " +  data );//diag
	}
    }//end selectionSort

    //======================================================
    
    // VOID version of insertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order

    // BEST CASE: O(n) comparisons, O(1) swaps - when array list is already sorted in ascending order; comparisons only to rightmost element and no swaps

    // WORST CASE: O(n^2) comparisons, O(n^2) swaps - the array list is in descending order; requires comparisons through all of sorted partition and varying swaps
    public static void insertionSort( ArrayList<Comparable> data ) {
	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    //diag:
		    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSort
}
