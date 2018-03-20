//Lynne Wang
//APCS1 pd1
//HW46 -- Al<B> Sorted!. 
//2017-12-05 

import java.util.ArrayList;

public class ALTester {

    //instantiation
    ArrayList<Comparable> arrList = new ArrayList<Comparable>();

    //constructor
    public ALTester() {
	for(int i = 0; i < 23; i++)
	    arrList.add(i);
    }

    //overriden toString()
    public String toString() {
	String retStr = "[";
	for(int i = 0; i < arrList.size() - 1; i++)
	    retStr += arrList.get(i) + ",";
	retStr = retStr.substring(0, retStr.length() - 1);
	retStr += "]";
	return retStr;
    }

    //checks if array is sorted in ascending order (smallest to largest)
    public boolean sorted() {
        for(int i = 0; i < arrList.size() - 1; i++)
	    if (! ((arrList.get(i)).compareTo(arrList.get(i+1)) <= 0))
		return false;
	return true;
    }

    //main
    public static void main( String[] args ) {
	ALTester foo = new ALTester();
	
	System.out.println(foo);
	System.out.println(foo.sorted()); //returns true

	foo.arrList.set(5,2);
	System.out.println(foo);
	System.out.println(foo.sorted()); //returns false

	foo.arrList.set(5,4);
	System.out.println(foo);
	System.out.println(foo.sorted()); //returns true

	foo.arrList.set(1,0);
	System.out.println(foo);
	System.out.println(foo.sorted()); //returns true

	foo.arrList.set(2,9);
	System.out.println(foo);
	System.out.println(foo.sorted()); //returns false
    }
}
