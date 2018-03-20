//Lynne Wang
//APCS2 pd1
//HW16: About Face
//2018-03-08

public class Mysterion {

    public static void printArr( int[] arr) {
	for (int i = 0; i < arr.length; i++)
	    System.out.print(arr[i] + ",");
    }
    
    public static void swap(int[] arr, int a, int b) {
	int placeholder = arr[a];
	arr[a] = arr[b];
	arr[b] = placeholder;
    }

    /*
      - arr = array
      - a = begIndex - beginning index of range
      - b = endIndex - ending index of range
      - c = centralIndex - index number that other numbers will be compared to
      - The function will sort the numbers between (and including) index a and 
      index b. Numbers in that range smaller than c will be placed to the left 
      of c; numbers in that range greater than c will be placed to the right 
      of c.
     */
    public static int containerOrder(int[] arr, int begIndex, int endIndex, int centralIndex) {
	int v = arr[centralIndex];
	swap(arr, centralIndex, endIndex);
	int s = begIndex;
	for(int i = begIndex; i < endIndex; i++)
	    if (arr[i] < v) {
		swap(arr, s, i);
		s += 1;
	    }
	swap(arr, endIndex, s);
	return s;
    }

    public static void main( String[] args ) {
	int[] arr1 = {3,12,5,1,7};
	System.out.println(containerOrder(arr1, 0, 4, 2));
	printArr(arr1);

	int[] arr2 = {9,8,7,6,5,4};
	System.out.println(containerOrder(arr2, 0, 4, 2));
	printArr(arr2);

	int[] arr3 = {3,12,5,1,7};
	System.out.println(containerOrder(arr3, 0, 4, 1));
	printArr(arr3);

	int[] arr4 = {3,12,5,1,7};
	System.out.println(containerOrder(arr4, 2, 4, 2));
	printArr(arr4);
    }
}
