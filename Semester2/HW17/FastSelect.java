//Lynne Wang
//APCS2 pd1
//HW17: So So Fast
//2018-03-12

/*
fastselect algo:
------------------------------------------------------
- takes in array and yth smallest value (starting from 0)
- from partition, pivot will always be in final position
- partitions array into two based on pivot
- recurses side of the index you are looking for

Best Case: good pivot index; consistently decreases search set by a fraction
- O(n)

Worst Case: bad pivot index is at; array is already sorted or chose max/min num 
- O(n^2)

Average: O(n)
*/

public class FastSelect {

    //Helper Methods
    //Swapper
    public static void swap( int x, int y, int[] arr ) {
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
    }

    //print input array 
    public static void printArr( int[] arr ) {
	for ( int i : arr )
	    System.out.print( i + " " );
	System.out.println();
    }

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

    public static int fastselect(int[] arr, int index) {
	return fastselect(arr, index, 0, arr.length - 1);
    }

    public static int fastselect(int[] arr, int index, int left, int right) {
	int median = (left + right) / 2;
        int p = partition(arr, left, right, median);
        if (p > index) {
            return fastselect(arr, index, left, p-1);
        }
        else if (p < index) {
            return fastselect(arr, index, p+1, right);
        }
        else {
            return arr[index];
        }
    }

    public static void main( String[] args ) {

	//best case
	int[] arr1 = {10,7,9,0,6};
	System.out.println(fastselect(arr1, 0));
	System.out.println(fastselect(arr1, 1));
	System.out.println(fastselect(arr1, 2));
	System.out.println(fastselect(arr1, 3));
	System.out.println(fastselect(arr1, 4));
	
	//worst case
	int[] arr2 = {1,2,3,4,5};
	System.out.println(fastselect(arr2, 0));
	System.out.println(fastselect(arr2, 1));
	System.out.println(fastselect(arr2, 2));
	System.out.println(fastselect(arr2, 3));
	System.out.println(fastselect(arr2, 4));
    }
}
