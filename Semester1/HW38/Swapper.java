//Lynne Wang
//APCS1 pd1
//HW38 -- Put It Together
//2017-11-22

/*
- populate: populates 2D String array with a String, of value between 100 and 9999
- retStr: prints out the array. Each row has its own line.
- Switch - takes in a String, first index, and last index as parameters. Creates array, swaps values, then returns modified string
 */

import cs1.Keyboard;

public class Swapper {

    public static void populate( String[][] arr ) {
	for(int i = 0; i < arr.length; i++)
	    for(int x = 0; x < arr[0].length; x++)
		arr[i][x] = "" + (int)(Math.random() * 9900 + 100);
    }

    public static void retStr( String[][] arr ) {
	for(int i = 0; i < arr.length; i++) {
	    for(int x = 0; x < arr[0].length; x++)
	        System.out.print(arr[i][x] + "\t");
	    System.out.println("");
	}
    }

    public static String Switch( String str, int a, int b ) {
	String[] arr = new String[str.length()];
	for(int i = 0; i < str.length(); i++)
	    arr[i] = str.substring(i,i+1);
        String c = arr[a];
	arr[a] = arr[b];
	arr[b] = c;
	String retStr = "";
	for(int i = 0; i < arr.length; i++)
	    retStr += arr[i];
	return retStr;
    }

    public static void main( String[] args ) {

        String[][] arr = new String[2][2];
	populate(arr);
        retStr(arr);

        System.out.print("Rows start at index 0. Select the row you would like to modify: ");
        int row = Keyboard.readInt();

	System.out.print("Columns start at index 0. Select the column you would like to modify: ");
	int col = Keyboard.readInt();

        System.out.print("Items start at index 0. Select the first term you want to switch: ");
	int a = Keyboard.readInt();

        System.out.print("Items start at index 0. Select the second term you want to switch: ");
	int b = Keyboard.readInt();	

        if (a >= 0 && b < (arr[row][col]).length()) {
	    System.out.println(Switch(arr[row][col], a, b));
	}
        else {
	    System.out.println("\n!!!Invalid index!!!");
	}
    }
}
