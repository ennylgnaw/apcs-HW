//Team Naked Frog (Lynne Wang, Simon Tsui)
//APCS1 pd1
//HW53 -- Solid Comparative Analysis
//2017-12-14

/*
  BUBBLE SORT - large elements "bubble" to the "top" (end of the list)
  -BEST CASE - the arrayList is already sorted (in ascending order). This requires no swaps.
  -WORST CASE - the arrayList is in descending order. This requires the most swaps.

  INSERTION SORT - divides arrayList into "sorted" and "unsorted" partitions
  -BEST CASE - the arrayList is already sorted (in ascending order). This requires no swaps.
  -WORST CASE - the arrayList is in descending order. This requires the most swaps.

  SELECTION SORT - insert elements, from left-to-right, into their correct positions
  -BEST CASE and WORST CASE are the same. You have to swap in each pass (with another element or self-swap)
*/

import java.util.*;

public class SortTester{

    //main method
    public static void main(String[] args){

        //**************************************************************
	//BUBBLE SORT
	System.out.println("**************************************************************");
	ArrayList<Comparable> worstCaseBub= new ArrayList<Comparable>();
	ArrayList<Comparable> bestCaseBub= new ArrayList<Comparable>();

	System.out.println("For BubbleSort: \n");//for BubbleSort
	
        //WORST CASE SCENARIO - all elements are in descending order (requires most swaps)
	System.out.println("WORST CASE SCENARIO:");
	for(int i = 5; i > 0; i--)
	    worstCaseBub.add(i); //adds nums 5 to 1 in descending order	
	System.out.println("Unsorted: " + worstCaseBub);
	MySorts.bubbleSort(worstCaseBub);
	System.out.println("Sorted: " + worstCaseBub + "\n\n");

	//BEST CASE SCENARIO - all elements are in ascending order (already sorted)
	System.out.println("BEST CASE SCENARIO:");
	for(Comparable c: worstCaseBub){
	    bestCaseBub.add(c);
	}
	System.out.println("Unsorted: " + bestCaseBub);
	MySorts.bubbleSort(bestCaseBub);
	System.out.println("Sorted: " + bestCaseBub + "\n\n");
	//**************************************************************

	//**************************************************************
	//INSERTION SORT
	System.out.println("**************************************************************");
        ArrayList<Comparable> worstCaseIns= new ArrayList<Comparable>();
	ArrayList<Comparable> bestCaseIns= new ArrayList<Comparable>();
	
	System.out.println("For InsertionSort: \n");//for InsertionSort
	
        //WORST CASE SCENARIO - all elements are in descending order (requires most comparisons to be made, and most swaps)
	System.out.println("WORST CASE SCENARIO:");
	for(int i = 5; i > 0; i--)
	    worstCaseIns.add(i); //adds nums 5 to 1 in descending order	
	System.out.println("Unsorted: " + worstCaseIns);
	MySorts.insertionSort(worstCaseIns);
	System.out.println("Sorted: " + worstCaseIns + "\n\n");

	//BEST CASE SCENARIO - all elements are in ascending order (already sorted, no swaps made)
	System.out.println("BEST CASE SCENARIO:");
	for(Comparable c: worstCaseIns){
	    bestCaseIns.add(c);
	}
	System.out.println("Unsorted: " + bestCaseIns);
	MySorts.insertionSort(bestCaseIns);
	System.out.println("Sorted: " + bestCaseIns + "\n\n");
	//**************************************************************

        //**************************************************************
	//SELECTION SORT
	System.out.println("**************************************************************");
        ArrayList<Comparable> worstCaseSel= new ArrayList<Comparable>();
	ArrayList<Comparable> bestCaseSel= new ArrayList<Comparable>();
	
	System.out.println("For SelectionSort: \n");//for SelectionSort
	
        //WORST CASE SCENARIO - same for all cases, self-swaps used
	System.out.println("WORST CASE SCENARIO:");
	for(int i = 5; i > 0; i--)
	    worstCaseSel.add(i); //adds nums 5 to 1 in descending order	
	System.out.println("Unsorted: " + worstCaseSel);
	MySorts.selectionSort(worstCaseSel);
	System.out.println("Sorted: " + worstCaseSel + "\n\n");

	//BEST CASE SCENARIO - same for all cases, self swaps used
	System.out.println("BEST CASE SCENARIO:");
	for(Comparable c: worstCaseSel){
	    bestCaseSel.add(c);
	}
	System.out.println("Unsorted: " + bestCaseSel);
	MySorts.selectionSort(bestCaseSel);
	System.out.println("Sorted: " + bestCaseSel);
	//**************************************************************
    }
}
