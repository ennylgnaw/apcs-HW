//Team tandemBike (Lynne Wang, Lily Yan)
//APCS2 pd1
//HW #07: A Man, A Plan, A Canal: Panama!
//2018-02-14

public class Resrever {

    //(a)
    //reverse a String in O(n) time
    public static String reverseA(String str) {
	String s = "";
	//starting from last letter, add letter to end of the new string, s
	for(int i = str.length() - 1; i >= 0; i--)
	    s += str.substring(i,i+1);
	return s;
    }

    //(b)  
    //reverse a String in O(logn) time
    public static String reverseB(String str) {
        if (str.length() == 1)
	    return str;
	//employs method similar to merge sort
	return reverseB(str.substring(str.length()/2)) +
	    reverseB(str.substring(0, str.length()/2));
    }
    
    
    //main
    public static void main(String[] args) {

	//reverseA tests
	System.out.println(reverseA("hello"));
	System.out.println(reverseA("desserts"));
	System.out.println(reverseA("stressed"));
	System.out.println(reverseA("a"));
	System.out.println(reverseA("me"));

	//reverseB tests
	System.out.println(reverseB("hello"));
	System.out.println(reverseB("desserts"));
	System.out.println(reverseB("stressed"));
	System.out.println(reverseB("a"));
	System.out.println(reverseB("me"));
    }
}
