//Lynne Wang
//APCS2 pd1
//HW18 -- QuickSort
//2018-03-13t
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): The middle index is used as the pivot. The partition method will 
 * partition the array into a left side and right side, and the pivot is in 
 * its final position. qsort will recursively sort both sides of the pivot, 
 * dividing and conquering as each pivot ends in its final position.
 *
 * 2a. Worst pivot choice and associated runtime: 
 * When the smallest or largest number is chosen as a pivot. This can happen 
 * if you choose the leftmost or rightmost element as your pivot in a sorted 
 * array. 
 * Runtime: O(n^2)
 *
 * 2b. Best pivot choice and associated runtime:
 * When the median number is chosen as the pivot. 
 * Runtime: O(nlogn). However, this is hard to 
 * gauge when your array is unsorted and large (you don't know where it is).
 * It is generally good practice to choose a random pivot in a shuffled array;
 * however, choosing the pivot at the middle index in a shuffled array also 
 * works.
 *
 * 3. Approach to handling duplicate values in array:
 * The way my qsort algorithm is written, it matters not whether or not there 
 * are duplicates. After all, duplicates will be grouped together in the end 
 * regardless of how many there are.
 *****************************************************/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/

    //uses method overloading
    public static void qsort( int[] d ) {
	qsort(d, 0, d.length - 1);
    }

    public static void qsort( int[] d, int lo, int hi )
    { 
	int med = (lo + hi) / 2; //pivot is median (middle index)
	if (lo < hi) {
	    int pivot = partition(d, lo, hi, med); //partitions array, returns pivot
	    qsort(d, lo, pivot - 1); //left side
	    qsort(d, pivot + 1, hi); //right side
	}
    }

	//you may need a helper method...
	//and that is partition
	public static int partition( int arr[], int start, int end, int pivot) {
	    int v = arr[pivot];
	    swap( pivot, end, arr);
	    int s = start;
	    for( int i = start; i < end; i++ ) {
		if ( arr[i] <= v) {
		    swap( i, s, arr );
		    s++;}
	    }
	    swap(s,end,arr);
	    return s;
	}

    //main method for testing
    public static void main( String[] args )
    {
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);

	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
        /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
