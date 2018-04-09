//Lynne Wang
//APCS2 pd1
//HW #26: DeIteratour
//2018-03-27

/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWorkAL 
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) 
    { 
        for( Integer i : L )
	    if (i == key)
		return true;
	return false;
    }

    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) 
    { 
        Iterator iter = L.iterator();
	while (iter.hasNext())
	    if (iter.next() == key)
		return true;
	return false;
    }
    
    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) 
    {
	List<Integer> retList = new ArrayList<Integer>();
	for( Integer i : L ) 
	    if ( (int)i % 2 == 1 )
		retList.add(i);
	return retList;
    }

    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) 
    { 
        Iterator iter = L.iterator();
	List<Integer> retList = new ArrayList<Integer>();
	while (iter.hasNext()) {
	    if ((int)iter.next() % 2 == 1)
		retList.add((Integer)iter.next());
	}
	return retList;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) 
    { 
        Iterator iter = L.iterator();
	while (iter.hasNext())
	    if ((int)iter.next() % 2 == 0)
		iter.remove();
    }


    public static void main( String [] args ) 
    {
	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...


	// a) using a FOREACH loop


	// b) explicitly using an iterator


	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );

	//for( int i = 0; i < 10; i++ )
	//  L.add(i);
	
	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);

	/*
	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);
	*/
	
	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);
	/*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class ItrWork

