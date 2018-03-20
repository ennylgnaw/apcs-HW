//Lynne Wang
//APCS2 pd1
//HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!. . .
//2018-02-07

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  - The algorithm recursively calls merge on two halves of the inputted array
  - Base Case: if length of array is 1, the array is sorted, and you can return it
  ======================================*/

public class MergeSort
{
    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b )
    {
	int[] mergedArr = new int[a.length + b.length]; //new empty array
	int A = 0; int B = 0; int AB = 0;
	while (A < a.length && B < b.length) { //while neither array is "empty"
	    if (a[A] < b[B]) {
		mergedArr[AB] = a[A];
		AB += 1; A += 1;
	    }
	    else {
		mergedArr[AB] = b[B];
		AB += 1; B += 1;
	    }
	}
	while (A < a.length) { //append leftover elements from a
	    mergedArr[AB] = a[A];
	    AB += 1; A += 1;
	}
	while (B < b.length) { //append leftover elements from b
	    mergedArr[AB] = b[B];
	    AB += 1; B += 1;
	}
	return mergedArr;
    }//end merge()


    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr )
    {
	//Base Case
	if (arr.length == 1)
	    return arr;
        //Temp arrays (split input array into two)
	int[] temp1 = new int[arr.length / 2];
	int[] temp2 = new int[arr.length - (arr.length / 2)];
	for (int i = 0; i < temp1.length; i++)
	    temp1[i] = arr[i];
	int z = temp1.length;
	for (int x = 0; x < temp2.length; x++) {
	    temp2[x] = arr[z];
	    z += 1;
        }
	return (merge(sort(temp1), sort(temp2))); //recursively splits array
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
